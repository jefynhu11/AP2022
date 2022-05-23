package org.framework.supports;

import java.io.File;

public class CreateFolder {
    public static void createDirectory(String path){
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

}
