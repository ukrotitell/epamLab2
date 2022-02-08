package org.epam.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.epam.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentsWriter {

    public void writeInFile(List<Student> list, String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
