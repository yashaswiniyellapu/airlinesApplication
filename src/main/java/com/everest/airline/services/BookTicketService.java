package com.everest.airline.services;

import com.everest.airline.database.DataParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class BookTicketService {
    private Long flightNumber;

    public BookTicketService(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void updateData(Path path, String updatedLine) throws IOException {
        if (updatedLine != null) {
            File directory = new File(String.valueOf(path));
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.getName().contains(Long.toString(flightNumber))) ;
                    DataParser data = new DataParser(file);
                    String line = data.readFile();
                    if (file.getName().equalsIgnoreCase(Long.toString(flightNumber) + ".txt")) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        line = line.replace(line, updatedLine);
                        writer.write(line);
                        writer.close();
                        break;
                    }
                }

            }
        }
    }

}
