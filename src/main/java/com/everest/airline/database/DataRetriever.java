package com.everest.airline.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataRetriever {
    private File file;

    public DataRetriever(File file) {
        this.file = file;
    }

    public String readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader.readLine();
    }
}
