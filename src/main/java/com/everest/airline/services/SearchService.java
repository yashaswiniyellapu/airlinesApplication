package com.everest.airline.services;

import com.everest.airline.database.Data;
import com.everest.airline.database.DataParser;
import com.everest.airline.database.FileHandler;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Component
public class SearchService {

    public List<Flight> flight(String source, String destination, String date) throws IOException {
        Data flight = new Data();
        return List.of(flight.returnFlight(source, destination, date));

    }

    public void seatsLeft(List<Flight> returnedFlightData) throws IOException {
        for (Flight flight : returnedFlightData) {
            FileHandler fileHandler = new FileHandler(flight.getSource(), flight.getDestination(), flight.getDepartureDate().toString());
            File file = fileHandler.getFileData(Path.of("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData"));
            DataParser data = new DataParser(file);
            String line = data.readFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            if (line != null) {
                if (line.contains(Integer.toString(flight.getAvailableSeats()))) {
                    line = line.replace(Integer.toString(flight.getAvailableSeats()), Integer.toString(flight.getAvailableSeats() - 1));
                    writer.write(line);
                    writer.close();
                }
            }

        }

    }

}

