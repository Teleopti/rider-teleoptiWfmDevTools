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
                .filter(PathMaker::isDeveloperToolsRepo)
                .findFirst().get();
    }

    private static boolean isDeveloperToolsRepo(String path) {
        return containsSolutionFile(path) && containsConfigFile(path);
    }

    private static boolean containsSolutionFile(String path) {
        if (path == null) {
            return false;
        }
        File[] solutions = new File(path).listFiles((dir, name) -> {
            String lower = name.toLowerCase();
            return lower.endsWith(".sln") || lower.endsWith(".slnx");
        });
        return solutions != null && solutions.length > 0;
    }

    private static boolean containsConfigFile(String path) {
        if (path == null) {
            return false;
        }
        return new File(Paths.get(path, ".com.teleopti.wfm.developer.tools.json").toString()).exists();
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
