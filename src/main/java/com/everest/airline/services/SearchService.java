package com.everest.airline.services;

import com.everest.airline.database.DataReader;
import com.everest.airline.database.DirectoryReader;
import com.everest.airline.database.FlightDataAssign;
import com.everest.airline.database.RetrieveFlightClassObjects;
import com.everest.airline.model.Flight;
import com.everest.airline.views.FlightClassData;
import com.everest.airline.views.FlightClassFilter;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SearchService {
    private final RetrieveFlightClassObjects flightClassObject = new RetrieveFlightClassObjects();

    private FlightClassData flightClassType;
    private FlightClassFilter filter;
   private double totalFare;
   private double totalClassFare;
    private FlightDataAssign flightClass;
    private FlightClassData economicClass = flightClassObject.getFlightClassObjects("economic");
   private FlightClassData firstClass = flightClassObject.getFlightClassObjects("first");
   private FlightClassData secondClass = flightClassObject.getFlightClassObjects("second");


    public List<Flight> flight(String source, String destination, String date, String passengersCount, String classType) throws Exception {
        List<String[]> fileData;
        List<Flight> flightList = new ArrayList<>();
        Flight flight;
     FlightClassData test = new RetrieveFlightClassObjects().getFlightClassObjects("economic");
        DirectoryReader fileHandler = new DirectoryReader(source, destination, date);
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
            flightClass = new FlightDataAssign(economicClassSeats, secondClassSeats, firstClassSeats, economicCapacity, secondClassCapacity, firstClassCapacity);

           flight = new Flight(flightNumber, from, to, departureDate, departureTime, arrivalTime, availableSeats,test,test,test );

            filter= new FlightClassFilter(classType);
             flightClassType = filter.filterClass(flight);
                if(flightClassType.validateData(numberOfPassengers))
                {
                    flightList.add(flight);
                    totalFare=flightClassType.getTotalFare()*numberOfPassengers;
                    totalClassFare = flightClassType.getTotalFare();

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

    public List<Flight> testFlightObject(String source, String destination, String date, String passengersCount, String classType) {
        return DataReader.getFilesData().stream().map(Map.Entry::getValue).
                filter(e -> (e[1].equalsIgnoreCase(source)) && (e)[2].equalsIgnoreCase(destination) && (e[3].
                        equalsIgnoreCase(date))).map(e ->
                {
                    setFlightClassData(Integer.parseInt(e[7]), Integer.parseInt(e[8]), Integer.parseInt(e[9]), Integer.parseInt(e[10]), Integer.parseInt(e[11]), Integer.parseInt(e[12]));
                    System.out.println(checkPassengerSeatsAvailability(Integer.parseInt(passengersCount), flightClassObject.getFlightClassObjects(classType).getSeatsLeft()) + " check");
                    if (checkPassengerSeatsAvailability(Integer.parseInt(passengersCount), flightClassObject.getFlightClassObjects(classType).getSeatsLeft())) {
                        System.out.println(e[1] + " " + e[2] + " " + e[3]);
                        return new Flight(Long.parseLong(e[0]), e[1], e[2], LocalDate.parse(e[3]),
                                LocalTime.parse(e[4]), LocalTime.parse(e[5]), Integer.parseInt(e[6]),
                                flightClassObject.getFlightClassObjects("economic"), flightClassObject.getFlightClassObjects("second"), flightClassObject.getFlightClassObjects("first"));
                    }
                    return null;
                }).collect(Collectors.toList());
    }

    private void setFlightClassData(int economicClassSeats, int secondClassSeats, int firstClassSeats, int economicCapacity, int secondClassCapacity, int firstClassCapacity) {
        economicClass.setSeatsLeft(economicClassSeats);
        economicClass.setCapacity(economicCapacity);
        secondClass.setSeatsLeft(secondClassSeats);
        secondClass.setCapacity(secondClassCapacity);
        firstClass.setSeatsLeft(firstClassSeats);
        firstClass.setCapacity(firstClassCapacity);
    }
    private boolean checkPassengerSeatsAvailability(int passengerCount, int availableSeats)
    {
        return passengerCount <= availableSeats;
    }

    }

