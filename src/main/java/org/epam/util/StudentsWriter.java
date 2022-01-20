package org.epam.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.epam.entity.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentsWriter {

    private String path = "src/main/resources/students";

    public void writeInFile(List<Student> list) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
