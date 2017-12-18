package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.PathMaker;

public class FixMyConfigFlow extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.Run(e,
                PathMaker.InRepo(".debug-Setup"),
                PathMaker.InRepo(".debug-Setup\\FixMyConfigFlow.bat")
        );
    }
}
