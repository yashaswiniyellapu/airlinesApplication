package com.everest.airline.services;

import com.everest.airline.database.DataReader;
import com.everest.airline.exceptions.SeatsUnavailableException;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;
import com.everest.airline.views.EconomicClass;
import com.everest.airline.views.FirstClass;
import com.everest.airline.views.FlightClassType;
import com.everest.airline.views.SecondClass;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class SearchService {

    public List<Flight> flightObjectTest
            (String source, String destination, String date, int passengersCount, String classType) {
        return DataReader.multipleFilesData().stream().map(Map.Entry::getValue).
                filter(strings -> strings[1].equalsIgnoreCase(source) && strings[2].equalsIgnoreCase(destination)
                        && strings[3].equalsIgnoreCase(date)).
                map(data -> {
                            Flight flight = new Flight(Long.parseLong(data[0]), data[1], data[2],
                                    LocalDate.parse(data[3]),
                                    LocalTime.parse(data[4]), LocalTime.parse(data[5]),
                                    new EconomicClass(Integer.parseInt(data[10]), Integer.parseInt(data[7])),
                                    new SecondClass(Integer.parseInt(data[11]), Integer.parseInt(data[8])),
                                    new FirstClass(Integer.parseInt(data[12]), Integer.parseInt(data[9])));
                            double classFare = new TotalFareCalculation(flight.flightClassesData(classType),
                                    LocalDate.parse(data[3]), classType).byDays();
                            FlightClassType flightClass = flight.flightClassesData(classType);
                            flightClass.setClassFare(classFare);
                            flightClass.setTotalFare(classFare * passengersCount);
                            if (validateSeats(passengersCount, flightClass.getSeatsLeft())) {
                                return flight;
                            } else {
                                throw new SeatsUnavailableException(classType, passengersCount);
                            }
                        }
                ).collect(Collectors.toList());

    }

    private boolean validateSeats(int passengersCount, int availableSeats) {
        return passengersCount <= availableSeats;
    }

}

//  public Flight(long number, String source, String destination, LocalDate departureDate,LocalTime departureTime,LocalTime arrivalTime, FlightClassType economicClass, FlightClassType secondClass, FlightClassType firstClass) {
//            long flightNumber = Long.parseLong(name[0]);
//            String from = name[1];
//            String to = name[2];
//            LocalDate departureDate = LocalDate.parse(name[3]);
//            LocalTime departureTime = LocalTime.parse(name[4]);
//            LocalTime arrivalTime = LocalTime.parse(name[5]);
//            int availableSeats = Integer.parseInt(name[6]);
//            int economicClassSeats = Integer.parseInt(name[7]);
//            int secondClassSeats = Integer.parseInt(name[8]);
//            int firstClassSeats = Integer.parseInt(name[9]);
//            int economicCapacity = Integer.parseInt(name[10]);
//            int numberOfPassengers = Integer.parseInt(passengersCount);
//            int firstClassCapacity = Integer.parseInt(name[11]);
//            int secondClassCapacity = Integer.parseInt(name[12]);