package org.fastclicker.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * FastClickerGUI
 */
public class FastClickerGUI extends JFrame {
  private JButton toggleBtn;
  private JButton triggerKeyBtn;
  private JTextField cpsField;

  public FastClickerGUI() {

    // Window
    setTitle("FastClicker");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(250, 250);
    setLayout(new BorderLayout());

    // Look and feel
    setLookAndFeel();

    // Font
    Font customFont = new Font("Cambria", Font.PLAIN, 12);
    UIManager.put("Label.font", customFont);
    UIManager.put("Button.font", customFont);
    UIManager.put("TextField.font", customFont);
    UIManager.put("ComboBox.font", customFont);

    // Top Panel
    JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));

    // Components
    topPanel.add(new JLabel("Clicks/s:"));
    cpsField = new JTextField("5");
    topPanel.add(cpsField);

    topPanel.add(new JLabel("Trigger key:"));
    triggerKeyBtn = new JButton("F9");
    topPanel.add(triggerKeyBtn);

    // Bottom Panel
    JPanel bottomPanel = new JPanel(new GridLayout(2, 2, 5, 5));

    // Components
    toggleBtn = new JButton("Start");
    bottomPanel.add(toggleBtn);

    // Add panels to frame
    add(topPanel, BorderLayout.NORTH);
    add(bottomPanel, BorderLayout.SOUTH);

    setVisible(true);
  }

  public int getCPS() {
    try {
      return Integer.parseInt(cpsField.getText());
    } catch (NumberFormatException e) {
      return 0;
    }
  }

  public void addToggleStartBtnListener(ActionListener listener) {
    toggleBtn.addActionListener(listener);
  }

  public void setToggleBtnText(String text) {
    toggleBtn.setText(text);
  }

  public void addTriggerKeyModalListener(ActionListener listener) {
    triggerKeyBtn.addActionListener(listener);
  }

  public void setTriggerKeyBtnText(String text) {
    triggerKeyBtn.setText(text);
  }

  private void setLookAndFeel() {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
