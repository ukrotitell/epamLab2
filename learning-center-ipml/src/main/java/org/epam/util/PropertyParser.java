package org.epam.util;


import com.sun.tools.javac.Main;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;
@Slf4j
public class PropertyParser {

    public String getPropertyVariable() {
        Properties prop = new Properties();
        {
            try {
                //load a properties file from class path, inside static method
                prop.load(Main.class.getClassLoader().getResourceAsStream("properties.properties"));
            } catch (IOException ex) {
                log.error("Файл с properties не был найден");
                ex.printStackTrace();
            }
        }
        return prop.getProperty("properties");
    }
}
