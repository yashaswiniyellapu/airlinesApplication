package com.everest.airline.services;

import com.everest.airline.database.Data;
import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class BookTicketService {
    private Long flightNumber;

    public BookTicketService(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void seatsLeft(Path path) throws IOException {
        File directory = new File(String.valueOf(Path.of("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData")));
        File[] listOfFiles = directory.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.getName().contains(Long.toString(flightNumber))) ;
                DataParser data = new DataParser(file);
                String line = data.readFile();
                String[] flightData = line.split(",");
                String flightId = flightData[0];
                String source = flightData[1];
                String destination = flightData[2];
                LocalDate departureDate = LocalDate.parse(flightData[3]);
                int seatsAvailable = Integer.parseInt(flightData[6]);
                    if (flightId.equals(Long.toString(flightNumber))) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        line = line.replace(Integer.toString(seatsAvailable), Integer.toString(seatsAvailable - 1));
                        writer.write(line);
                        writer.close();
                    }
                }

            }
    }
}
