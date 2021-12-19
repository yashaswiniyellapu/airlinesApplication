package com.everest.airline.database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String from;
    private String to;
    private String departureDate;

    public FileHandler(String from, String to, String date) {

        this.from = from;
        this.to = to;
        this.departureDate = date;

    }

    public List<String[]> getFileData(Path filePath) throws IOException {
        List<String[]> fileList = new ArrayList<>();
        File directory = new File(String.valueOf(filePath));
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                DataParser data = new DataParser(file);
                String line = data.readFile();
                String[] fileData = line.split(",");
                if (validateFileData(fileData)) {
                    fileList.add(fileData);
                }
                else throw new NullPointerException();
            }
        }
        return fileList;
    }

    public boolean validateFileData(String[] fileData) {
        String source = fileData[1];
        String destination = fileData[2];
        String date = fileData[3];

        if (from.equalsIgnoreCase(source) &&
                to.equalsIgnoreCase(destination) &&
                departureDate.equalsIgnoreCase(date)) {
            return true;
        }

        return false;
    }

}
