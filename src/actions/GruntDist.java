package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.PathMaker;

public class GruntDist extends AnAction {

    public GruntDist() {
        super("grunt dist", null,  IconLoader.getIcon("/GruntDist.png"));
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setDescription(PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\.node\\grunt.cmd") + " dist");
        if (new OptionsReader().Read().NpmStartAndFriends)
            event.getPresentation().setEnabled(false);
        else
            event.getPresentation().setEnabled(true);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\WFM"),
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\.node\\grunt.cmd"),
                "dist"
        );
    }
}
