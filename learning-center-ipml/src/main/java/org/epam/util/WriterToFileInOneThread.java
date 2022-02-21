package org.epam.util;

import lombok.extern.slf4j.Slf4j;
import org.epam.Student;

//изменить название
@Slf4j
public class WriterToFileInOneThread implements Runnable {

    private String path;
    private Student student;

    public WriterToFileInOneThread(Student student, String path) {
        this.student = student;
        this.path = path;
    }

    WriterToFile writer = new WriterToFile();

    @Override
    public void run() {
        log.info(Thread.currentThread().getName());
        writer.writeInfoToFile(path, student);
        try {
            log.info(Thread.currentThread().getName() + " спит");
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            log.error("Поток прерван");
            e.printStackTrace();
        }
    }
}

