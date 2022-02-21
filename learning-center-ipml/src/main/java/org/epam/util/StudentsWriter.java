package org.epam.util;

import lombok.extern.slf4j.Slf4j;
import org.epam.Student;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class StudentsWriter {

    ClearFile clearFile = new ClearFile();

    ExecutorService service = Executors.newCachedThreadPool();

    public void writeInFile(String path, List<Student> studentList) {
        clearFile.clearFile(path);

        for (Student student : studentList) {
            service.submit(new WriterToFileInOneThread(student, path));
        }
        service.shutdown();
    }
}
































