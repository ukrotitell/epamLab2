package org.epam.util;

import entity.Program;
import org.epam.exception.IllegalInitialDataException;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramsParser {
    org.epam.util.PropertyParser propertyParser = new org.epam.util.PropertyParser();
    String property = propertyParser.getPropertyVariable();

    public List<Program> getListOfPrograms() throws FileNotFoundException, IllegalInitialDataException {
        List<Program> programList = new ArrayList<>();
        InputStream inputStream = new FileInputStream("src/main/resources/" + property);
        Yaml yaml = new Yaml(new Constructor(Program.class));
        try {
            for (Object object : yaml.loadAll(inputStream)) {
                Program program = (Program) object;
                programList.add(program);
            }
        } catch (Exception e) {
            throw (new IllegalInitialDataException("Произошла ошибка. Проверьте исходные данные.\n" + e.getCause()));
        }
        return programList;
    }
}
