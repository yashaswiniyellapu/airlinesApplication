package com.everest.airline.database;

import com.everest.airline.model.Flight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Data {

    public Flight returnFlight(String source, String destination, String date) {
        try {
            File directory = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData");
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        String line;
                        line = new BufferedReader(new FileReader(file)).readLine();
                        String[] flightsData = line.split(",");
                        if (flightsData[1].equalsIgnoreCase(source) && flightsData[2].equalsIgnoreCase(destination) && flightsData[3].equalsIgnoreCase(date)) {
                            return new Flight(Integer.parseInt(flightsData[0]), flightsData[1], flightsData[2], LocalDate.parse(flightsData[3]), LocalTime.parse(flightsData[4]), LocalTime.parse(flightsData[5]), Integer.parseInt(flightsData[6]));
                        }


                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}



