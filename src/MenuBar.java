import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

class MenuBar extends JMenuBar {

  private final UserInterface ui;

  MenuBar(UserInterface ui) {
    this.ui = ui;

    JMenu menuGame = new JMenu("Game");
    menuGame.setMnemonic(KeyEvent.VK_G);
    JMenuItem startStopTimer = new JMenuItem("Start/Stop Timer");
    startStopTimer.setMnemonic(KeyEvent.VK_S);
    startStopTimer.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        ui.toggleTimer();
      }
    });
    menuGame.add(startStopTimer);
    JMenuItem lifeCycle = new JMenuItem("Next Generation");
    lifeCycle.setMnemonic(KeyEvent.VK_N);
    lifeCycle.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        ui.game.lifeCycle();
        ui.repaint();
      }
    });
    menuGame.add(lifeCycle);
    JMenuItem timerRateInc = new JMenuItem("Increase Timer Rate");
    timerRateInc.setMnemonic(KeyEvent.VK_I);
    timerRateInc.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        ui.changeTimerRate(-25);
      }
    });
    menuGame.add(timerRateInc);
    JMenuItem timerRateDec = new JMenuItem("Decrease Timer Rate");
    timerRateDec.setMnemonic(KeyEvent.VK_D);
    timerRateDec.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        ui.changeTimerRate(25);
      }
    });
    menuGame.add(timerRateDec);
    JMenuItem turboMode = new JMenuItem("Start Turbo Mode");
    turboMode.setMnemonic(KeyEvent.VK_M);
    turboMode.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        ui.enableTurboMode();
      }
    });
    menuGame.add(turboMode);
    this.add(menuGame);

    JMenu menuPresets = new JMenu("Presets");
    menuPresets.setMnemonic(KeyEvent.VK_P);
    menuPresets.add(new PresetMenuItem("empty", this.ui));
    JMenu random = new JMenu("Random");
    for (int i = 5; i < 100; i += 5) {
      JMenuItem randomRatio = new JMenuItem(i + "%");
      float ratio = i / 100f;
      randomRatio.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          ui.game.setGrid(Presets.random(ui.rows, ui.cols, ratio));
          ui.repaint();
        }
      });
      random.add(randomRatio);
    }
    menuPresets.add(random);
    // objects that do not change
    JMenu stillLife = new JMenu("Still Life");
    stillLife.add(new PresetMenuItem("block", this.ui));
    stillLife.add(new PresetMenuItem("beehive", this.ui));
    stillLife.add(new PresetMenuItem("loaf", this.ui));
    stillLife.add(new PresetMenuItem("tub", this.ui));
    stillLife.add(new PresetMenuItem("boat", this.ui));
    stillLife.add(new PresetMenuItem("longboat", this.ui));
    stillLife.add(new PresetMenuItem("ship", this.ui));
    stillLife.add(new PresetMenuItem("barge", this.ui));
    stillLife.add(new PresetMenuItem("snake", this.ui));
    stillLife.add(new PresetMenuItem("python", this.ui));
    stillLife.add(new PresetMenuItem("fishhook", this.ui));
    menuPresets.add(stillLife);
    // objects that return to their initial state
    JMenu oscillators = new JMenu("Oscillator");
    oscillators.add(new PresetMenuItem("blinker", this.ui));
    oscillators.add(new PresetMenuItem("toad", this.ui));
    oscillators.add(new PresetMenuItem("clock", this.ui));
    oscillators.add(new PresetMenuItem("beacon", this.ui));
    oscillators.add(new PresetMenuItem("bipole", this.ui));
    oscillators.add(new PresetMenuItem("tumbler", this.ui));
    oscillators.add(new PresetMenuItem("octagon", this.ui));
    oscillators.add(new PresetMenuItem("pulsar", this.ui));
    oscillators.add(new PresetMenuItem("1-2-3-4", this.ui));
    oscillators.add(new PresetMenuItem("aforall", this.ui));
    oscillators.add(new PresetMenuItem("pentadecathlon", this.ui));
    oscillators.add(new PresetMenuItem("queenbeeshuttle", this.ui));
    oscillators.add(new PresetMenuItem("achimsp11", this.ui));
    menuPresets.add(oscillators);
    // objects that move forward
    JMenu spaceships = new JMenu("Spaceship");
    spaceships.add(new PresetMenuItem("glider", this.ui));
    spaceships.add(new PresetMenuItem("lwss", this.ui));
    spaceships.add(new PresetMenuItem("mwss", this.ui));
    spaceships.add(new PresetMenuItem("hwss", this.ui));
    spaceships.add(new PresetMenuItem("canadagoose", this.ui));
    spaceships.add(new PresetMenuItem("copperhead", this.ui));
    spaceships.add(new PresetMenuItem("loafer", this.ui));
    menuPresets.add(spaceships);
    // objects that expand strongly
    JMenu methuselah = new JMenu("Methuselah");
    methuselah.add(new PresetMenuItem("rpentomino", this.ui));
    methuselah.add(new PresetMenuItem("bheptomino", this.ui));
    methuselah.add(new PresetMenuItem("cheptomino", this.ui));
    methuselah.add(new PresetMenuItem("eheptomino", this.ui));
    methuselah.add(new PresetMenuItem("fheptomino", this.ui));
    methuselah.add(new PresetMenuItem("pi", this.ui));
    methuselah.add(new PresetMenuItem("acorn", this.ui));
    methuselah.add(new PresetMenuItem("blocknglider", this.ui));
    methuselah.add(new PresetMenuItem("bunnies", this.ui));
    methuselah.add(new PresetMenuItem("rabbits", this.ui));
    methuselah.add(new PresetMenuItem("glidersbythedozen", this.ui));
    methuselah.add(new PresetMenuItem("herschel", this.ui));
    methuselah.add(new PresetMenuItem("thunderbird", this.ui));
    methuselah.add(new PresetMenuItem("23334m", this.ui));
    methuselah.add(new PresetMenuItem("7468m", this.ui));
    menuPresets.add(methuselah);
    // objects that leave no living cell
    JMenu extinction = new JMenu("Extinction");
    extinction.add(new PresetMenuItem("diehard", this.ui));
    menuPresets.add(extinction);
    // objects that grow infinitely
    JMenu growing = new JMenu("Growth");
    growing.add(new PresetMenuItem("gosperglidergun", this.ui));
    growing.add(new PresetMenuItem("blocklayingswitchengine1", this.ui));
    growing.add(new PresetMenuItem("blocklayingswitchengine2", this.ui));
    growing.add(new PresetMenuItem("blocklayingswitchengine3", this.ui));
    menuPresets.add(growing);
    this.add(menuPresets);
  }

}
