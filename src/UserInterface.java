import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

class UserInterface extends JPanel {

  final Game game;
  final int rows;
  final int cols;
  final int cellWidth;

  private Timer timer;
  private int timerRate;
  private boolean timerRunning;

  UserInterface(int rows, int cols, int cellWidth) {
    this.game = new Game(rows, cols);
    this.rows = rows;
    this.cols = cols;
    this.cellWidth = cellWidth;

    this.timerRate = 250;
  }

  @Override
  public void paintComponent(Graphics graphics) {
    boolean[] grid = this.game.getGrid();
    super.paintComponent(graphics);
    int offsetX = (this.getWidth() - this.cols * this.cellWidth) / 2;
    int offsetY = (this.getHeight() - this.rows * this.cellWidth) / 2;
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.cols; col++) {
        graphics.setColor(grid[this.game.getIndex(row, col)] ? Color.BLACK : Color.WHITE);
        graphics.fillRect(offsetX + this.cellWidth * col, offsetY + this.cellWidth * row, this.cellWidth, this.cellWidth);
      }
    }
  }

  private void setTimerEnabled(boolean running) {
    if (running) {
      this.timer = new Timer();
      this.timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          game.lifeCycle();
          repaint();
        }
      }, 0, this.timerRate);
    } else {
      this.timer.cancel();
      this.timer.purge();
    }
    this.timerRunning = running;
  }

  void toggleTimer() {
    this.setTimerEnabled(!this.timerRunning);
  }

  void changeTimerRate(int rate) {
    // turbo mode
    if (this.timerRate == 1) {
      if (rate < 0) {
        return;
      }
      this.timerRate = 0;
    }
    int lowerLimit = 25;
    int upperLimit = 4000;
    this.timerRate += rate;
    this.timerRate = this.timerRate < lowerLimit ? lowerLimit : (this.timerRate > upperLimit ? upperLimit : this.timerRate);
    if (this.timerRate == lowerLimit + 1) {
      this.timerRate = lowerLimit;
    }
    if (this.timerRunning) {
      this.toggleTimer(); // cancel
      this.toggleTimer(); // restart
    }
    System.out.println("Timer Rate: " + Math.round(1000f / this.timerRate * 10) / 10f + " generations/s");
  }

  boolean isTimerRunning() {
    return this.timerRunning;
  }

  // generates 100 new generations per second, can place a heavy load on the processor
  void enableTurboMode() {
    this.timerRate = 1;
    if (this.timerRunning) {
      this.toggleTimer(); // cancel
      this.toggleTimer(); // restart
    }
    System.out.println("Timer Rate: 100.0 generations/s");
  }

  static void showUserInterface(int rows, int cols, int cellWidth) {
    JFrame frame = new JFrame("Conway's Game Of Life");
    UserInterface ui = new UserInterface(rows, cols, cellWidth);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(ui);
    frame.setSize(cols * cellWidth + 25, rows * cellWidth + 75);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.setJMenuBar(new MenuBar(ui));
    frame.setVisible(true);
  }

}
