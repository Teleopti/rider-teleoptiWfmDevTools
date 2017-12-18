package com.teleopti.wfm.developer.tools;

import com.intellij.openapi.actionSystem.AnActionEvent;
import org.apache.commons.lang.ArrayUtils;

import java.io.File;
import java.io.IOException;

public class CommandRunner {

    public static void Run(AnActionEvent event, String directory, String... command) {
        File directoryF = new File(directory);
        File fileF = new File(command[0]);
        command[0] = fileF.toString();
//
//        System.out.println(directory);
//        System.out.println(command);
//        System.out.println(directoryF.toString());
//        System.out.println(directoryF.exists());
//        System.out.println(fileF.toString());
//        System.out.println(fileF.exists());
        //Project project = event.getData(PlatformDataKeys.PROJECT);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.directory(directoryF);
            String[] cmdStart = {
                    PathMaker.InSystem32("cmd.exe"),
                    "/c",
                    "start"
            };
            builder.command((String[])ArrayUtils.addAll(cmdStart, command));
            //System.out.println(builder.command().toString());
            Process p = builder.start();
            p.waitFor();
            //BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            //String line;
            //while ((line = input.readLine()) != null) {
            //    System.out.println(line);
            //}
            //Messages.showMessageDialog(project, "Done! Did it work? I dunno...", "Done", Messages.getInformationIcon());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
