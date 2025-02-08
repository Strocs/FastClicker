package org.fastclicker.model;

import java.awt.event.KeyEvent;

/**
 * FastClickerModel
 */
public class FastClickerConfig {
  private int triggerKeyCode = KeyEvent.VK_F9;

  public void setTriggerKeyCode(int keyCode) {
    this.triggerKeyCode = keyCode;
  }

  public int getTriggerKeyCode() {
    return this.triggerKeyCode;
  }
}
