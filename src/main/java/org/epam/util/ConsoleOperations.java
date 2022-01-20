package org.epam.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleOperations {
    private BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public ConsoleOperations() {
    }

    public String readStringFromConsole() {
        String text = "";
        try {
            text = read.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public int readIntFromConsole() {
        int number = 0;
        try {
            number = Integer.parseInt(read.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
    }
}
