package org.epam.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.epam.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentsParser {


    public List<Student> readStudents(String path) {

        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = null;
        try {
            students = mapper.readValue(new File(path),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
