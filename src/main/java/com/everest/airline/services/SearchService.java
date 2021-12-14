package com.everest.airline.services;

import com.everest.airline.database.Data;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SearchService {
    private List<Flight> flightData;

    public List<Flight> flight(String source, String destination, String date) throws IOException {
        Data flight = new Data();
        flightData = List.of(flight.returnFlight(source, destination, date));
        return flightData;

    }
}

