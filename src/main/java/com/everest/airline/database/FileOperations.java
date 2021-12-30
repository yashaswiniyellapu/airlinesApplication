package com.everest.airline.database;

import com.everest.airline.comparator.FlightComparator;
import com.everest.airline.model.Flight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FileOperations {
    private static final List<Long> deletedId=new ArrayList();
    public static List<Flight> getFlights() {
        List<Flight> allFlights = new ArrayList<>();
        File directory = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData");
        File[] listOfFiles = directory.listFiles();
        for (File file : Objects.requireNonNull(listOfFiles)) {
            try {
                String[] line = new DataRetriever(file).readFile().split(",");
                long flightNumber = Long.parseLong(line[0]);
                String from = line[1];
                String to = line[2];
                LocalDate departureDate = LocalDate.parse(line[3]);
                LocalTime departureTime = LocalTime.parse(line[4]);
                LocalTime arrivalTime = LocalTime.parse(line[5]);
                int availableSeats = Integer.parseInt(line[6]);
                int economicClassSeats = Integer.parseInt(line[7]);
                int secondClassSeats = Integer.parseInt(line[8]);
                int firstClassSeats = Integer.parseInt(line[9]);
                int economicCapacity = Integer.parseInt(line[10]);
                int firstClassCapacity = Integer.parseInt(line[11]);
                int secondClassCapacity = Integer.parseInt(line[12]);
                Flight flight = new Flight(flightNumber, from, to, departureDate, departureTime, arrivalTime, availableSeats, economicClassSeats, secondClassSeats, firstClassSeats, economicCapacity, secondClassCapacity, firstClassCapacity);
                allFlights.add(flight);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        allFlights.sort(new FlightComparator());
        return allFlights;
    }

    public static void createFile(Long flightNumber, Flight flight) {

        try {
            FileWriter writer = new FileWriter("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData/" + flightNumber + ".txt");
            writer.write(flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                    flight.getArrivalTime() + "," + flight.getAvailableSeats() +
                    "," + flight.getEconomicClassSeats() + "," + flight.getSecondClassSeats() + "," + flight.getFirstClassSeats() + "," +
                    flight.getEconomicCapacity() + "," + flight.getSecondClassCapacity() + "," + flight.getFirstClassCapacity());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateData(Long flightNumber, Flight flight) {
        try {
            FileWriter writer = new FileWriter("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData/" + flightNumber + ".txt");
            writer.write(flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                    flight.getArrivalTime() + "," + flight.getAvailableSeats() +
                    "," + flight.getEconomicClassSeats() + "," + flight.getSecondClassSeats() + "," + flight.getFirstClassSeats() + "," +
                    flight.getEconomicCapacity() + "," + flight.getSecondClassCapacity() + "," + flight.getFirstClassCapacity());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFile(Long flightNumber)
    {
        deletedId.add(flightNumber);
        File file = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData/" + flightNumber + ".txt");
         file.delete();
    }
}
