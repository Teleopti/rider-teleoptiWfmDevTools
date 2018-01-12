package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.PathMaker;
import com.teleopti.wfm.developer.tools.ResourceExtractor;

public class Etl extends AnAction {

    public Etl() {
        super("Etl", "Etl", null);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo("Teleopti.Analytics.Etl.ServiceConsoleHost\\bin\\Debug"),
                PathMaker.InRepo("Teleopti.Analytics.Etl.ServiceConsoleHost\\bin\\Debug\\Teleopti.Analytics.Etl.ServiceConsoleHost.exe")
        );
    }
}
