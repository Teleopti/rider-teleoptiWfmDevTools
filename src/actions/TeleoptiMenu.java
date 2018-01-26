package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;

public class TeleoptiMenu extends DefaultActionGroup {

    public TeleoptiMenu(){
        super("TeleoptiMenu", true );
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setEnabled(true);
        event.getPresentation().setText("Teleopti");
    }
}