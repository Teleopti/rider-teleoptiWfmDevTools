package com.teleopti.wfm.developer.tools;

import com.intellij.openapi.project.ProjectManager;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class PathMaker {

    private static String RepoPath() {
        Stream<String> projectPaths = Arrays.stream(ProjectManager.getInstance().getOpenProjects())
                .map(x -> x.getBasePath());

        return Stream.concat(projectPaths, Arrays.stream(new DevStuff().devPaths))
                .filter(x -> new File(Paths.get(x, "CruiseControl.sln").toString()).exists())
                .findFirst().get();
    }

    public static String InRepo(String path) {
        return Paths.get(RepoPath(), path).toString();
    }

    public static String InTemp(String path) {
        new File(InRepo(".com.teleopti.wfm.developer.tools")).mkdirs();
        return InRepo(Paths.get(".com.teleopti.wfm.developer.tools", path).toString());
    }

    public static String InSystem32(String path) {
        return Paths.get(System.getenv("WINDIR"), "system32", path).toString();
    }
}
