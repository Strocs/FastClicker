package org.fastclicker.service;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * FastClickerService
 */
public class FastClickerService {
  private Robot robot;
  private boolean isClicking = false;

  public FastClickerService() {
    try {
      robot = new Robot();
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }

  public void startClicking(int cps) {
    if (isClicking)
      return;

    isClicking = true;
    int delay = 1000 / cps;

    new Thread(() -> {
      try {
        while (isClicking) {
          robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
          robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
          Thread.sleep(delay);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      isClicking = false;
    }).start();
  }

  public void stopClicking() {
    isClicking = false;
  }

  public boolean getClickingState() {
    return this.isClicking;
  }
}
