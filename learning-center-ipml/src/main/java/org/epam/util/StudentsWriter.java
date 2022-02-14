package org.epam.util;

import org.epam.Student;
import org.epam.repository.StudentRepository;
import org.epam.repository.StudentService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentsWriter {

    String path = "src/main/resources/studentsReport";

    public void writeInFile(String path) {
        StudentsParser studentsFile = new StudentsParser();
        StudentRepository studentRepository = new StudentRepository(studentsFile);
        StudentService studentService = new StudentService(studentRepository);
        int size = studentService.getListOfStudents().size();


        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            Student student = studentService.getListOfStudents().get(i);

            service.submit(new Runnable() {

                public void run() {
                    System.out.println(Thread.currentThread().getId());

                    try (OutputStreamWriter writer =
                                 new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8)) {

                        writer.write(String.valueOf(student));

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


        /*ExecutorService executor = Executors.newFixedThreadPool(size);

        for (int i = 0; i < size; i++) {

            Runnable worker = new MyRunnable(studentService.getListOfStudents().get(i));
            executor.execute(worker);
            System.out.println(Thread.currentThread().getId());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        System.out.println("\nFinished all threads");
    }*/
            });
        }
    }
}