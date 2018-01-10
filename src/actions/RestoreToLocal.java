package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.PathMaker;

public class RestoreToLocal extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        if (new OptionsReader().Read().RestoreToLocalFlow) {
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(".debug-Setup"),
                    PathMaker.InRepo(".debug-Setup\\Restore to Local.bat"),
                    "/flow"
            );
        } else {
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(".debug-Setup"),
                    PathMaker.InRepo(".debug-Setup\\Restore to Local.bat")
            );
        }
    }
}
