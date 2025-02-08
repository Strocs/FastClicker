package org.fastclicker;

import javax.swing.SwingUtilities;

import org.fastclicker.view.FastClickerGUI;
import org.fastclicker.controller.FastClickerController;
import org.fastclicker.model.FastClickerConfig;

/**
 * Main
 */
public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      FastClickerGUI view = new FastClickerGUI();
      FastClickerConfig model = new FastClickerConfig();
      new FastClickerController(model, view);
    });
  }
}
