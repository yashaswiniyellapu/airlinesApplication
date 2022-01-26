package com.everest.airline.services;

import com.everest.airline.accesslayer.FlightDao;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;
import com.everest.airline.views.FlightClassType;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchService {

    public List<Flight> flightObjectTest
            (String source, String destination, String date, int passengersCount, String classType) {

        return new FlightDao().getAll(source, destination, date).stream().map(flight -> {
            FlightClassType flightClass = flight.flightClassesData(classType);
            if (flightClass.validateSeats(passengersCount, flightClass.getSeatsLeft())) {
                TotalFareCalculation classFare = new
                        TotalFareCalculation(flight.flightClassesData(classType), Date.valueOf(date), classType);
                flightClass.setClassFare(classFare.byDays());
                flightClass.setTotalFare(classFare.byDays() * passengersCount);
            }
            return flight;
        }).collect(Collectors.toList());

    }
}