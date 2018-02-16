package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.Presentation;

public class TeleoptiMenu extends DefaultActionGroup {

    public TeleoptiMenu() {
        super("TeleoptiMenu", true);
    }

    private boolean _inUpdate = false;

    @Override
    public void update(AnActionEvent event) {
        if (_inUpdate)
            return;
        _inUpdate = true;
        Presentation presentation = event.getPresentation();
        if (!presentation.isEnabled())
            presentation.setEnabled(true);
        presentation.setText("Teleopti");
        _inUpdate = false;
    }

}