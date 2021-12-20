package com.everest.airline.services;

import com.everest.airline.database.DataParser;
import com.everest.airline.database.FileHandler;
import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
import com.everest.airline.model.FlightFilterTest;
import com.everest.airline.price.Test;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchService {
    private double price;

    public List<Flight> flight(String source, String destination, String date,String passengersCount,String classType) throws Exception {
        List<String[]> fileData;
        List<Flight> flightList = new ArrayList<>();
        FileHandler fileHandler = new FileHandler(source, destination, date);
        fileData = fileHandler.getFileData(Path.of("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData"));
        for(String[] name:fileData)
        {
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
            int numberOfPassengers= Integer.parseInt(passengersCount);
            int firstClassCapacity = Integer.parseInt(name[11]);
            int secondClassCapacity = Integer.parseInt(name[12]);

            if(new ValidateData().checkFlightData(numberOfPassengers,classType,economicClassSeats,firstClassSeats,secondClassSeats))
            {
                flightList.add(new Flight(flightNumber, from, to, departureDate, departureTime, arrivalTime, availableSeats, economicClassSeats, secondClassSeats, firstClassSeats,economicCapacity,secondClassCapacity,firstClassCapacity));
                Test test = new Test(economicCapacity,secondClassSeats,firstClassSeats);
                price =test.basePrice(economicClassSeats);
                FlightFilterTest filter = new FlightFilterTest(classType);
                System.out.println(filter.filterFlight(Integer.parseInt(passengersCount),economicClassSeats,secondClassSeats,firstClassSeats,"fareCalculation"));

            }
            else{throw new IllegalStateException();}

        }

        return flightList;
    }
    public double getPrice()
    {
          return price;
    }
}

