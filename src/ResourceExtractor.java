package com.teleopti.wfm.developer.tools;

import java.io.*;

public class ResourceExtractor {

    public static void Extract(String resource, String file) {
        try {
            try (InputStream resourceStream = ResourceExtractor.class.getClassLoader().getResourceAsStream(resource)) {
                try (FileOutputStream fileStream = new FileOutputStream(new File(file))) {
                    byte[] buffer = new byte[32768];
                    int length;
                    while ((length = resourceStream.read(buffer)) > 0) {
                        fileStream.write(buffer, 0, length);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
