package org.epam.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentsParser {
    public List<Student> readStudents() {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = null;
        try {
            students = mapper.readValue(new File("src/main/resources/students.json"),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
