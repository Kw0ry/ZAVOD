package com.company;


import com.company.tools.JsonFactory;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.readJsonFile();
    }
}
