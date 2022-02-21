package org.epam.util;

import lombok.extern.slf4j.Slf4j;
import org.epam.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
@Slf4j
public class WriterToFile {

    public void writeInfoToFile(String path, Student student) {
        try (OutputStreamWriter writer =
                     new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8)) {

            writer.write(student + "\n");
        } catch (IOException e) {
            log.error("Проблемы с записью в файл");
            e.printStackTrace();
        }

    }
}
