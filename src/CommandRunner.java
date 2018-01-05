package com.teleopti.wfm.developer.tools;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.apache.commons.lang.ArrayUtils;

import java.io.File;
import java.io.IOException;

public class CommandRunner {

    public static void StartInCommandWindow(AnActionEvent event, String directory, String... command) {
        File directoryF = new File(directory);
        File fileF = new File(command[0]);
        command[0] = fileF.toString();
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.directory(directoryF);
            String[] cmdStart = {
                    PathMaker.InSystem32("cmd.exe"),
                    "/c",
                    "start"
            };
            builder.command((String[])ArrayUtils.addAll(cmdStart, command));
            Process p = builder.start();
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
