package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

@Component
public class DataUpdater {

    public void updateData(Long flightNumber, String classType, String passengerCount, List<Flight> flightData) throws Exception {
        for (Flight flight : flightData) {
            String updatedLine;
            File directory = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData");
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.getName().equalsIgnoreCase(flightNumber + ".txt")) ;
                    DataParser data = new DataParser(file);
                    String line = data.readFile();
                    if (file.getName().equalsIgnoreCase(flightNumber + ".txt") && (flight.getNumber() == flightNumber)) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        updatedLine = new FlightClassFliter().seatsLeft(classType, passengerCount, flight);
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

