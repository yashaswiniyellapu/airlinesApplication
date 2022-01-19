package com.everest.airline.database;

import java.io.*;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


public class DataReader {
    private DataReader(){}

    public static Set<Map.Entry<String, String[]>> getFilesData() {
        return Objects.requireNonNull(DirectoryReader.getListOfFiles()).stream().map(file -> {
            try {
                return new BufferedReader(new FileReader(String.valueOf(file.getValue()))).readLine().split(",");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toMap(strings -> {
            assert strings != null;
            return strings[0];
        }, strings -> strings)).entrySet();

    }
}