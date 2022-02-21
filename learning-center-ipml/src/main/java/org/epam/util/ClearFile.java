package org.epam.util;


import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ClearFile {

    public void clearFile(String path) {

        try {
            FileChannel.open(Paths.get(path), StandardOpenOption.WRITE).truncate(0).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
