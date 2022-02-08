package org.epam.util;

import org.epam.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class StudentsWriterTest {


    @Test
    void shouldWriteInFile() throws IOException {
        String pathTest = "src/test/resources/students.txt";
        StudentsWriter studentsWriter = new StudentsWriter();
        Student student1 = new Student(1, "Igorrrrr", 1, Map.of(
                "module1", 5,
                "module2", 33
        ), 19.0);
        Student student2 = new Student(2, "Oleg", 2, Map.of(
                "module1", 5,
                "module2", 33
        ), 19.0);
        studentsWriter.writeInFile(List.of(student1, student2), pathTest);
        List<String> fileStream = Files.readAllLines(Paths.get(pathTest));
        int numberOfLines = fileStream.size();
        assertEquals(19, numberOfLines);

    }

}