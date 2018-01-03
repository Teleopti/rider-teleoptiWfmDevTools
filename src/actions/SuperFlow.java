package com.teleopti.wfm.developer.tools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.extensions.PluginId;
import com.sun.webkit.plugin.PluginManager;
import com.teleopti.wfm.developer.tools.CommandRunner;
import com.teleopti.wfm.developer.tools.PathMaker;

import java.nio.file.Path;

public class SuperFlow extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        CommandRunner.Run(e, PathMaker.InRepo(""), PathMaker.InActions("SuperFlow.bat"));
    }
}
