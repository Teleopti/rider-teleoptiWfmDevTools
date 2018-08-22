package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;

public class ActionRegistrator {
    public void RegisterAction(String id, AnAction action) {
        ActionManager actionManager = ActionManager.getInstance();
        actionManager.unregisterAction(id);
        actionManager.registerAction(id, action);
    }
}
