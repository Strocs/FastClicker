package org.fastclicker.view.events;

import java.awt.AWTEvent;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

/**
 * KeyPressListener
 */
public class KeyPressListener implements AWTEventListener {
  private Runnable action;
  private int triggerKeyCode;

  public KeyPressListener(Runnable action, int triggerKeyCode) {
    this.action = action;
    this.triggerKeyCode = triggerKeyCode;
  }

  @Override
  public void eventDispatched(AWTEvent e) {
    if (e instanceof KeyEvent) {
      KeyEvent keyEvent = (KeyEvent) e;
      if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
        if (keyEvent.getKeyCode() == triggerKeyCode) {
          action.run();
        }
      }
    }
  }

}
