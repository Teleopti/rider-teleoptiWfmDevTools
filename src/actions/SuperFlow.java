package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.PathMaker;
import com.teleopti.wfm.developer.tools.ResourceExtractor;

public class SuperFlow extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        ResourceExtractor.Extract("SuperFlow.bat", PathMaker.InTemp("SuperFlow.bat"));
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo(""),
                PathMaker.InTemp("SuperFlow.bat")
        );
    }
}
