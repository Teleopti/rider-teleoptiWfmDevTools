package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.*;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.OptionsAction;

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

        for(AnAction item: this.getChildren(event)){
            this.remove(item);
        }

        OptionsAction[] items = new OptionsReader().Read().TeleoptiMenu;
        if (items != null){
            for (OptionsAction item: items) {
                add(new PluginAction(item));
            }
        }

        _inUpdate = false;
    }

}