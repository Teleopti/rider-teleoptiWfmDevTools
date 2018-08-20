package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.OptionsReader;
import com.teleopti.wfm.developer.tools.PathMaker;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeleoptiMenuItem extends AnAction {

    private String _directory;
    private String[] _run;
    private String _description;

    private static Icon loadIcon(String icon){
        if (icon == null)
            return null;
        return IconLoader.getIcon("/" + icon);
    }

    public TeleoptiMenuItem(String text, String icon, String directory, String[] run) {
        super(text, null, loadIcon(icon));

        _directory = PathMaker.InRepo(directory);

        _run = run;
        _run[0] = PathMaker.InRepo(_run[0]);

        _description = String.join(" ", _run);
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setDescription(_description);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.StartInCommandWindow(e, _directory, _run);
    }
}
