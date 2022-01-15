package com.everest.airline.services;

<<<<<<< HEAD
import com.everest.airline.database.DataReader;
import com.everest.airline.database.DirectoryReader;
import com.everest.airline.database.RetrieveFlightClassObjects;
import com.everest.airline.model.Flight;
import com.everest.airline.views.FlightClassData;
||||||| da26066 (Had public constructor for flightClasses)
import com.everest.airline.database.DataReader;
import com.everest.airline.database.DirectoryReader;
import com.everest.airline.database.FlightDataAssign;
import com.everest.airline.database.RetrieveFlightClassObjects;
import com.everest.airline.model.Flight;
import com.everest.airline.views.FlightClassData;
=======
import com.everest.airline.database.FileHandler;
import com.everest.airline.database.FlightDataAssign;
>>>>>>> parent of da26066 (Had public constructor for flightClasses)
import com.everest.airline.views.FlightClassFilter;
import com.everest.airline.model.Flight;
import com.everest.airline.views.FlightClassType;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchService {

    private FlightClassType flightClassType;
    private FlightClassFilter filter;
   private double totalFare;
   private double totalClassFare;
    private FlightDataAssign economicClass;


    public List<Flight> flight(String source, String destination, String date, String passengersCount, String classType) throws Exception {
        List<String[]> fileData;
        List<Flight> flightList = new ArrayList<>();
        Flight flight;
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
            economicClass = new FlightDataAssign(economicClassSeats, secondClassSeats, firstClassSeats, economicCapacity, secondClassCapacity, firstClassCapacity);
            System.out.println(economicClass.getEconomicClassData().getCapacity()+" capacity "+economicCapacity);

           flight = new Flight(flightNumber, from, to, departureDate, departureTime, arrivalTime, availableSeats,economicClass );

            filter= new FlightClassFilter(classType);
                flightClassType = filter.filterClass(flight);
                if(flightClassType.validateData(numberOfPassengers))
                {
                    flightList.add(flight);
                    totalFare=flightClassType.getTotalFare()*numberOfPassengers;
                    totalClassFare = flightClassType.getTotalFare();

                }
                else
                {
                    throw new IllegalStateException();
                }

            }
        return flightList;
    }

    public double getTotalFare()
    {
        return totalFare;

    }
    public double getFare()
    {
        return totalClassFare;
    }
}

