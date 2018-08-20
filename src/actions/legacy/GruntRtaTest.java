package com.teleopti.wfm.developer.tools.actions.legacy;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.PathMaker;

public class GruntRtaTest extends AnAction {

    public GruntRtaTest() {
        super("grunt rtaTest", null,  IconLoader.getIcon("/GruntRtaTest.png"));
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setDescription(PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\.node\\grunt.cmd") + " rtaTest");
        if (new OptionsReader().Read().NpmStartAndFriends)
            event.getPresentation().setEnabled(false);
        else if (new OptionsReader().Read().NpmRunRtaTest)
            event.getPresentation().setEnabled(false);
        else
            event.getPresentation().setEnabled(true);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\WFM"),
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\.node\\grunt.cmd"),
                "rtaTest"
        );
    }
}
