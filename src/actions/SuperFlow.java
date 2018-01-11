package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.PathMaker;
import com.teleopti.wfm.developer.tools.ResourceExtractor;

public class SuperFlow extends AnAction {

    public SuperFlow() {
        super("Super Flow", "Super Flow", IconLoader.getIcon("/SuperFlow.png"));
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        ResourceExtractor.Extract("SuperFlow.bat", PathMaker.InTemp("SuperFlow.bat"));
        if (new OptionsReader().Read().RestoreToLocalFlow){
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(""),
                    PathMaker.InTemp("SuperFlow.bat"),
                    "/flow"
            );
        } else {
            CommandRunner.StartInCommandWindow(e,
                    PathMaker.InRepo(""),
                    PathMaker.InTemp("SuperFlow.bat")
            );
        }
    }
}
