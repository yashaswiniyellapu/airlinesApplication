package com.everest.airline.database;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class DataRetriever {
    private File file;
    private HashMap<Integer, String[]> fileData;

    public DataRetriever(File file) {
        this.file = file;
    }

    public DataRetriever() {
    }

    public String readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData/1001.txt"));
        return reader.readLine();
    }
//    public Map<String, String> getFilesData()
//    {
//        File[] listOfFiles = FileHandler.getListOfFiles();
//        return Arrays.stream(listOfFiles).collect(Collectors.toMap(value->value.getName().substring(0,4) ,value-> {
//            try {
//                return new BufferedReader(new FileReader(value)).readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }));
//
//    }

    public static Map<String, String[]> getFilesData() {
        return Objects.requireNonNull(FileHandler.getListOfFiles()).stream().map(file -> {
            try {
                return new BufferedReader(new FileReader(String.valueOf(file))).readLine().split(",");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toMap(strings -> {
            assert strings != null;
            return strings[0];
        }, strings -> strings));

    }
}
