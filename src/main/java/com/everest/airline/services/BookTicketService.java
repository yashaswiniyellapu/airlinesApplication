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

    public void seatsLeft(Path path, String numberOfPassengers) throws IOException {
        File directory = new File(String.valueOf(path));
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.getName().contains(Long.toString(flightNumber))) ;
                DataParser data = new DataParser(file);
                String line = data.readFile();
                String[] flightData = line.split(",");
                String flightId = flightData[0];
                int seatsAvailable = Integer.parseInt(flightData[6]);
                if (flightId.equals(Long.toString(flightNumber))) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    line = line.replace(Integer.toString(seatsAvailable), Integer.toString(seatsAvailable -(Integer.parseInt(numberOfPassengers)) ));
                    writer.write(line);
                    writer.close();
                    break;
                }
            }

        }
    }
}
