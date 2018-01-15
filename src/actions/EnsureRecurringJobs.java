package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.PathMaker;

public class EnsureRecurringJobs extends AnAction {

    public EnsureRecurringJobs() {
        super("EnsureRecurringJobs", null, null);
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setDescription(PathMaker.InRepo("Teleopti.Analytics.Etl.ServiceConsoleHost\\bin\\Debug\\Teleopti.Analytics.Etl.ServiceConsoleHost.exe") + " /EnsureRecurringJobs");
        event.getPresentation().setEnabled(new OptionsReader().Read().EtlEnsureRecurringJobs);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo("Teleopti.Analytics.Etl.ServiceConsoleHost\\bin\\Debug"),
                PathMaker.InRepo("Teleopti.Analytics.Etl.ServiceConsoleHost\\bin\\Debug\\Teleopti.Analytics.Etl.ServiceConsoleHost.exe"),
                "/EnsureRecurringJobs"
        );
    }
}
