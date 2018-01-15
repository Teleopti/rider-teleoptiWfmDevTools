package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.PathMaker;

public class FixMyConfigFlow extends AnAction {

    public FixMyConfigFlow() {
        super("FixMyConfigFlow", null,  IconLoader.getIcon("/FixMyConfigFlow.png"));
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setDescription(PathMaker.InRepo(".debug-Setup\\FixMyConfigFlow.bat"));
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo(".debug-Setup"),
                PathMaker.InRepo(".debug-Setup\\FixMyConfigFlow.bat")
        );
    }
}
