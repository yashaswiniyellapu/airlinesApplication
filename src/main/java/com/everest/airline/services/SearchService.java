package com.everest.airline.services;

import com.everest.airline.database.FileHandler;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchService {
    private double totalFare;

    public List<Flight> flight(String source, String destination, String date, String passengersCount, String classType) throws Exception {
        List<String[]> fileData;
        List<Flight> flightList = new ArrayList<>();
        FileHandler fileHandler = new FileHandler(source, destination, date);
        fileData = fileHandler.getFileData(Path.of("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData"));
        for (String[] name : fileData) {
            long flightNumber = Long.parseLong(name[0]);
            String from = name[1];
            String to = name[2];
            LocalDate departureDate = LocalDate.parse(name[3]);
            LocalTime departureTime = LocalTime.parse(name[4]);
            LocalTime arrivalTime = LocalTime.parse(name[5]);
            int availableSeats = Integer.parseInt(name[6]);
            int economicClassSeats = Integer.parseInt(name[7]);
            int secondClassSeats = Integer.parseInt(name[8]);
            int firstClassSeats = Integer.parseInt(name[9]);
            int economicCapacity = Integer.parseInt(name[10]);
            int numberOfPassengers = Integer.parseInt(passengersCount);
            int firstClassCapacity = Integer.parseInt(name[11]);
            int secondClassCapacity = Integer.parseInt(name[12]);

            if (new ValidateData().checkFlightData(numberOfPassengers, classType, economicClassSeats, firstClassSeats, secondClassSeats)) {
                flightList.add(new Flight(flightNumber, from, to, departureDate, departureTime, arrivalTime, availableSeats, economicClassSeats, secondClassSeats, firstClassSeats, economicCapacity, secondClassCapacity, firstClassCapacity));
                TotalFareCalculation fare = new TotalFareCalculation(economicCapacity, secondClassCapacity, firstClassCapacity, economicClassSeats, secondClassSeats, firstClassSeats);
                totalFare = fare.getTotalFare(classType);

            } else {
                throw new IllegalStateException();
            }

        }

        return flightList;
    }

    public double getTotalFare() {
        return totalFare;
    }
}

