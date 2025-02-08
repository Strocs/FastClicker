package org.fastclicker.controller;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import org.fastclicker.model.FastClickerConfig;
import org.fastclicker.service.FastClickerService;
import org.fastclicker.view.FastClickerGUI;
import org.fastclicker.view.KeyAssignModal;
import org.fastclicker.view.events.KeyPressListener;

/**
 * FastClickerController
 */
public class FastClickerController {
  private FastClickerService service;
  private FastClickerConfig config;
  private FastClickerGUI view;
  private KeyPressListener keyPressListener;

  public FastClickerController(FastClickerConfig config, FastClickerGUI view) {
    this.view = view;
    this.config = config;
    this.service = new FastClickerService();

    view.addToggleStartBtnListener(e -> handleToggleClicking());
    view.addTriggerKeyModalListener(e -> handleOpenTriggerKeyModal());

    this.keyPressListener = new KeyPressListener(() -> handleToggleClicking(), config.getTriggerKeyCode());
    Toolkit.getDefaultToolkit().addAWTEventListener(this.keyPressListener, AWTEvent.KEY_EVENT_MASK);
  }

  private void handleToggleClicking() {
    if (!service.getClickingState()) {
      service.startClicking(view.getCPS());
      view.setToggleBtnText("Stop");
    } else {
      service.stopClicking();
      view.setToggleBtnText("Start");
    }
  }

  private void handleOpenTriggerKeyModal() {
    new KeyAssignModal(keyCode -> {
      config.setTriggerKeyCode(keyCode);
      view.setTriggerKeyBtnText(KeyEvent.getKeyText(keyCode));
    });
  }
}
