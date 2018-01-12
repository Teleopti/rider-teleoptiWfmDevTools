package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.*;

public class SuperFlow extends AnAction {

    public SuperFlow() {
        super("Super Flow", "Super Flow", IconLoader.getIcon("/SuperFlow.png"));
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        ResourceExtractor.Extract("SuperFlow.bat", PathMaker.InTemp("SuperFlow.bat"));
        Options options = new OptionsReader().Read();
        if (options.RestoreToLocalFlow) {
            if (options.EtlEnsureRecurringJobsWithRetries) {
                CommandRunner.StartInCommandWindow(e,
                        PathMaker.InRepo(""),
                        PathMaker.InTemp("SuperFlow.bat"),
                        "/flow",
                        "/EnsureRecurringJobs"
                );
            } else {
                CommandRunner.StartInCommandWindow(e,
                        PathMaker.InRepo(""),
                        PathMaker.InTemp("SuperFlow.bat"),
                        "/flow"
                );
            }
        } else {
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(""),
                    PathMaker.InTemp("SuperFlow.bat")
            );
        }
    }
}
