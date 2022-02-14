package org.epam.util;

import org.epam.Student;
import org.epam.repository.StudentRepository;
import org.epam.repository.StudentService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MyRunnable implements Runnable {
    StudentsParser studentsFile = new StudentsParser();
    StudentRepository studentRepository = new StudentRepository(studentsFile);
    StudentService studentService = new StudentService(studentRepository);
    int size = studentService.getListOfStudents().size();
    String path = "src/main/resources/studentsReport";
    private Student student;

    MyRunnable(Student student) {
        this.student = student;
    }



    @Override
    public void run() {

        try (OutputStreamWriter writer =
                     new OutputStreamWriter(new FileOutputStream(path, true), StandardCharsets.UTF_8)){

            writer.write(String.valueOf(student));
        // do stuff
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


       /* try {
            FileOutputStream f = new FileOutputStream(path);
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(student);

            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/




        /*ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
