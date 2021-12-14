package com.everest.airline.database;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileHandler {
    private String from;
    private String to;
    private String departureDate;
    protected boolean isContains = false;
    protected boolean check;

    public FileHandler(String from, String to, String date) {

        this.from = from;
        this.to = to;
        this.departureDate = date;

    }


    public File getFileData(Path filePath) throws IOException {
        File fileName = null;
        File directory = new File(String.valueOf(filePath));
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                DataParser data = new DataParser(file);
                String line = data.readFile();
                String[] fileData = line.split(",");
                check = validateFileData(fileData);
                if (check) {
                    fileName = getFile(file);
                    break;

                }
            }
        }
        return fileName;
    }

    public boolean validateFileData(String[] fileData) {
        String source = fileData[1];
        String destination = fileData[2];
        String date = fileData[3];
        if (from.equalsIgnoreCase(source) &&
                to.equalsIgnoreCase(destination) &&
                departureDate.equalsIgnoreCase(date)) {
            isContains = true;
        }

        return isContains;
    }


    public File getFile(File file) {
        return file;
    }
}
