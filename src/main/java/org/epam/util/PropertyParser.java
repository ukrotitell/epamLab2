package org.epam.util;

import org.epam.Main;

import java.io.IOException;
import java.util.Properties;

public class PropertyParser {

    public String getPropertyVariable() {
        Properties prop = new Properties();
        {
            try {
                //load a properties file from class path, inside static method
               prop.load(Main.class.getClassLoader().getResourceAsStream("properties.properties"));
            } catch (
                    IOException ex) {
                ex.printStackTrace();
            }
        }
        return prop.getProperty("properties");
    }
}
