import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PresetMenuItem extends JMenuItem {

  // menu item for loading a preset
  PresetMenuItem(String preset, UserInterface ui) {
    this.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        if (ui.isTimerRunning()) {
          ui.toggleTimer();
        }
        try {
          Thread.sleep(400);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
        ui.game.setGrid(Presets.getPreset(preset, ui.rows, ui.cols));
        ui.repaint();
      }
    });
    this.setText(preset);
  }

}
