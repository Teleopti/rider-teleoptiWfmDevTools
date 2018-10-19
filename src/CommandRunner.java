package com.teleopti.wfm.developer.tools;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.apache.commons.lang.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandRunner {

    public static void StartInCommandWindow(AnActionEvent event, String directory, String... command) {
        try {

            final List<String> commands = new ArrayList<>();
            commands.add(PathMaker.InSystem32("cmd.exe"));
            commands.add("/c");
            commands.add("start");
            commands.add("\"\"");
            commands.addAll(Arrays.asList(command));

            ProcessBuilder builder = new ProcessBuilder(commands);
            builder.directory(new File(directory));

            Process p = builder.start();
            p.waitFor();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
