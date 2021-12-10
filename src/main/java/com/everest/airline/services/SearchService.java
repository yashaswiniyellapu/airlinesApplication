package com.everest.airline.services;

import com.everest.airline.database.Data;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class SearchService {

    public List<Flight> flight(String source, String destination, String date) {
        Data flight = new Data();
        List<Flight> data = List.of(flight.returnFlight(source, destination, date));
        return data;

    }

    public void leftOverSeats(List<Flight> returnedFlightData) {
        for (Flight flight : returnedFlightData) {
            try {
                File directory = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData");
                File[] listOfFiles = directory.listFiles();
                if (listOfFiles != null) {
                    for (File file : listOfFiles) {
                        String inputFileName = flight.getNumber() + ".txt";
                        if (inputFileName.equals(file.getName())) {
                            String line = new BufferedReader(new FileReader(file.getPath())).readLine();
                            BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath()));
                            if (line != null) {
                                if (line.contains(Long.toString(flight.getNumber())) && line.contains(Integer.toString(flight.getAvailableSeats()))) {
                                    line = line.replace(Integer.toString(flight.getAvailableSeats()), "" + (flight.getAvailableSeats() - 1));
                                    writer.write(line + "\n");

                                }
                                writer.close();
                            }

                        }

                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

