package com.everest.airline.database;

import com.everest.airline.model.Flight;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;

public class Data {

    public Flight returnFlight(String source, String destination, String date) throws IOException {
        FileHandler fileHandler = new FileHandler(source, destination, date);
        File dataFile = fileHandler.getFileData(Path.of("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData"));
        DataParser data = new DataParser(dataFile);
        String[] line = data.readFile().split(",");
        long flightNumber = Long.parseLong(line[0]);
        String from = line[1];
        String to = line[2];
        LocalDate departureDate = LocalDate.parse(line[3]);
        LocalTime departureTime = LocalTime.parse(line[4]);
        LocalTime arrivalTime = LocalTime.parse(line[5]);
        int availableSeats = Integer.parseInt(line[6]);
        return new Flight(flightNumber, from, to, departureDate, departureTime, arrivalTime, availableSeats);
    }
}



