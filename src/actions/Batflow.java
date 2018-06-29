package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.*;

public class BatFlow extends AnAction {

    public BatFlow() {
        super("Bat Flow", null, IconLoader.getIcon("/BatFlow.png"));
    }

    @Override
    public void update(AnActionEvent event) {
        if (!event.getPresentation().isEnabled())
            event.getPresentation().setEnabled(new OptionsReader().Read().BatflowThatWorks);
        event.getPresentation().setDescription("Holy stuff batman!");
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        //ResourceExtractor.Extract("BatFlow.wav", PathMaker.InTemp("BatFlow.wav"));
        //new SoundPlayer().Play(PathMaker.InTemp("BatFlow.wav"));

        CommandRunner.StartInCommandWindow(e,
                PathMaker.InRepo(""),
                PathMaker.InRepo("Teleopti.Develop.Batflow\\bin\\Debug\\Teleopti.Develop.Batflow.exe"),
                "flow"
        );

    }
}
