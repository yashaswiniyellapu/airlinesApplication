package com.everest.airline.services;

import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchService {

    public List<Flight> flight(String source, String destination, String date) {
        List<Flight> data = List.of(returnFlight(source, destination, date));
        System.out.println(data);

        return data.stream()
                .filter(f -> (f.getSource().equalsIgnoreCase(source) &&
                        f.getDestination().equalsIgnoreCase(destination) &&
                        f.getDepartureDate().equals(LocalDate.parse(date))))
                .collect(Collectors.toList());

    }

    public void testDecrement(List<Flight> returnedFlightData) {
        for (Flight flight : returnedFlightData) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData.txt"));
                File tempFile = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/temp.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.contains(Long.toString(flight.getNumber())) && line.contains(Integer.toString(flight.getAvailableSeats()))) {
                        line = line.replace(Integer.toString(flight.getAvailableSeats()), "" + (flight.getAvailableSeats() - 1));
                    }
                    writer.write(line + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            File data = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData.txt");
            data.delete();
            File newFile = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/temp.txt");
            newFile.renameTo(data);
        }
    }

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

