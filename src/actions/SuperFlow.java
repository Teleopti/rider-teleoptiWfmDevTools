package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.*;

public class SuperFlow extends AnAction {

    public SuperFlow() {
        super("Super Flow", null, IconLoader.getIcon("/SuperFlow.png"));
    }

    @Override
    public void update(AnActionEvent event) {
        if (!event.getPresentation().isEnabled())
            event.getPresentation().setEnabled(true);
        event.getPresentation().setDescription("Stuff and cats!");
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        ResourceExtractor.Extract("SuperFlow.wav", PathMaker.InTemp("SuperFlow.wav"));
        new SoundPlayer().Play(PathMaker.InTemp("SuperFlow.wav"));

        Options options = new OptionsReader().Read();

        if (options.NpmRunStartAlpha){

            ResourceExtractor.Extract("SuperFlow.0.2.2.bat", PathMaker.InTemp("SuperFlow.bat"));
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(""),
                    PathMaker.InTemp("SuperFlow.bat"),
                    PathMaker.InRepo(""),
                    ".com.teleopti.wfm.developer.tools"
            );

        } else if (options.BatflowThatWorks){

            ResourceExtractor.Extract("SuperFlow.0.1.5.bat", PathMaker.InTemp("SuperFlow.bat"));
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(""),
                    PathMaker.InTemp("SuperFlow.bat"),
                    PathMaker.InRepo(""),
                    ".com.teleopti.wfm.developer.tools"
            );

        } else if (options.ToolsFlowWithFixMyConfig && options.ToolsFlowWithInfraTestConfigWithOptionalToggleMode){

            ResourceExtractor.Extract("SuperFlow.0.1.4.bat", PathMaker.InTemp("SuperFlow.bat"));
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(""),
                    PathMaker.InTemp("SuperFlow.bat"),
                    PathMaker.InRepo(""),
                    ".com.teleopti.wfm.developer.tools"
            );

        } else if (options.ToolsFlowWithoutSQLCMD){

            ResourceExtractor.Extract("SuperFlow.0.1.3.bat", PathMaker.InTemp("SuperFlow.0.1.3.bat"));
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(""),
                    PathMaker.InTemp("SuperFlow.0.1.3.bat"),
                    PathMaker.InRepo(""),
                    ".com.teleopti.wfm.developer.tools"
            );

        } else {

            ResourceExtractor.Extract("SuperFlow.0.0.13.bat", PathMaker.InTemp("SuperFlow.0.0.13.bat"));
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(""),
                    PathMaker.InTemp("SuperFlow.0.0.13.bat"),
                    PathMaker.InRepo(""),
                    ".com.teleopti.wfm.developer.tools",
                    Boolean.toString(options.EtlEnsureRecurringJobsWithRetries),
                    Boolean.toString(options.NpmRunRtaTest)
            );

        }
    }
}
