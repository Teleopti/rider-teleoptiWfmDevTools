package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.PathMaker;

public class NpmRtaTest extends AnAction {

    public NpmRtaTest() {
        super("npm run rtaTest", null,  IconLoader.getIcon("/GruntRtaTest.png"));
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setDescription(PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\.node\\npm") + " run rtaTest");
        event.getPresentation().setEnabled(new OptionsReader().Read().NpmRunRtaTest);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\WFM"),
                PathMaker.InRepo("Teleopti.Ccc.Web\\Teleopti.Ccc.Web\\.node\\npm"),
                "run",
                "rtaTest"
        );
    }
}
