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
        ResourceExtractor.Extract("SuperFlow.bat", PathMaker.InTemp("SuperFlow.bat"));
        Options options = new OptionsReader().Read();
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo(""),
                PathMaker.InTemp("SuperFlow.bat"),
                PathMaker.InRepo(""),
                ".com.teleopti.wfm.developer.tools",
                Boolean.toString(options.EtlEnsureRecurringJobsWithRetries),
                Boolean.toString(options.NpmRunRtaTest)
        );
    }
}
