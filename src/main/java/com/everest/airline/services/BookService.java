package com.everest.airline.services;

import com.everest.airline.accesslayer.FlightDao;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    public void updateData(Long flightNumber, String classType, int passengerCount, List<Flight> flightData) {
        new FlightDao().update(flightNumber, classType, passengerCount);
    }
}

