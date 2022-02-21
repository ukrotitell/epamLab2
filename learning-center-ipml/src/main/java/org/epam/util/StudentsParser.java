package org.epam.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.epam.Student;
import java.io.File;
import java.io.IOException;
import java.util.List;
@Slf4j
public class StudentsParser {

    public List<Student> readStudents(String path) {

        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = null;
        try {
            students = mapper.readValue(new File(path),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            log.error("Проблема с чтением студентов из файла");
            e.printStackTrace();
        }

        return students;
    }
}
