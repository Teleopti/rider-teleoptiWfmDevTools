package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.PathMaker;

public class GruntNova extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.Run(e,
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\WFM"),
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\.node\\grunt.cmd"),
                "nova"
        );
    }
}