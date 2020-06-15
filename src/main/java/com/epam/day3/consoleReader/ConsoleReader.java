package com.epam.day3.consoleReader;

import com.epam.day3.exception.CustomException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

    public String readString() throws CustomException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        try {
                s = reader.readLine();
                return s;
        } catch (IOException e) {
            throw new CustomException("Incorrect input data", e);
        }
    }
}
