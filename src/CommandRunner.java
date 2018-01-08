package com.teleopti.wfm.developer.tools;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.apache.commons.lang.ArrayUtils;

import java.io.File;
import java.io.IOException;

public class CommandRunner {

    public static void StartInCommandWindow(AnActionEvent event, String directory, String... command) {
        command[0] = "\""  + new File(command[0]).toString() + "\"";
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.directory(new File(directory));
            String[] cmdStart = {
                    PathMaker.InSystem32("cmd.exe"),
                    "/c",
                    "start",
                    "\"\""
            };
            builder.command((String[])ArrayUtils.addAll(cmdStart, command));

//            for (String x: builder.command()) {
//                System.out.print(x);
//                System.out.print(" ");
//            }
//            System.out.println();

            Process p = builder.start();
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
