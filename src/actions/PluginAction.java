package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.util.IconLoader;
import com.teleopti.wfm.developer.tools.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PluginAction extends AnAction {

    private String _id;
    private String _description;
    private String _directory;
    private String[] _run;
    private String[] _script;

    public PluginAction(OptionsAction optionsAction) {
        super(optionsAction.Text, null, loadIcon(optionsAction.Icon));
        _id = optionsAction.Id;
        _description = optionsAction.Description;
        _directory = optionsAction.Directory;
        _run = optionsAction.Run;
        _script = optionsAction.Script;

        ActionManager actionManager = ActionManager.getInstance();
        actionManager.unregisterAction(_id);
        actionManager.registerAction(_id, this);
    }

    @Override
    public ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.EDT;
    }

    public int hashCode() {
        int h = java.util.Arrays.hashCode(_run);
        h = 31 * h + java.util.Arrays.hashCode(_script);
        h = 31 * h + _id.hashCode();
        return h;
    }

    @Override
    public void update(AnActionEvent event) {
        event.getPresentation().setDescription(description());
    }

    @Override
    public void actionPerformed(AnActionEvent e) {

        if (_script != null) {
            String file = _id + ".bat";
            try (PrintWriter out = new PrintWriter(PathMaker.InTemp(file))) {
                for (String line : _script) {
                    line = line.replace("%Repo%", PathMaker.InRepo(""));
                    line = line.replace("%PluginTemp%", ".com.teleopti.wfm.developer.tools");
                    out.println(line);
                }
                CommandRunner.StartInCommandWindow(e, PathMaker.InRepo(""), PathMaker.InTemp(file));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        if (_run != null)
            CommandRunner.StartInCommandWindow(e, PathMaker.InRepo(_directory), run());

    }

    private static Icon loadIcon(String icon) {
        if (icon == null)
            return null;
        return IconLoader.getIcon("/" + icon);
    }

    private String description() {
        String description = _description;
        String[] run = run();
        if (description == null && run != null)
            description = String.join(" ", run);
        return description;
    }

    private String[] run() {
        if (_run == null)
            return null;
        String[] run = new String[_run.length];
        System.arraycopy(_run, 0, run, 0, _run.length);
        if (run.length > 0)
            run[0] = PathMaker.InRepo(run[0]);
        return run;
    }
}


