package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.PathMaker;

public class CommandLine extends AnAction {

    public CommandLine() {
        super("WFM Command line", null,  IconLoader.getIcon("/CommandLine.png"));
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setDescription("cmd.exe " + PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\WFM") );
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\WFM"),
                PathMaker.InSystem32("cmd.exe")
        );
    }
}
