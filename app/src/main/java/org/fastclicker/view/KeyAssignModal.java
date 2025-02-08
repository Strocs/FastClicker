package org.fastclicker.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * KeyAssignModal
 */
public class KeyAssignModal extends JDialog {

  public KeyAssignModal(Consumer<Integer> onKeySelected) {
    setTitle("Assign Trigger Key");
    setSize(350, 150);
    setLayout(new BorderLayout());
    setModal(true);

    JLabel message = new JLabel("Press any key to assign as trigger key.", SwingConstants.CENTER);
    message.setFont(new Font("Sans-serif", Font.PLAIN, 14));
    add(message, BorderLayout.CENTER);

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        onKeySelected.accept(keyCode);
        dispose();
      }
    });

    setLocationRelativeTo(null);
    setVisible(true);

  }

}
