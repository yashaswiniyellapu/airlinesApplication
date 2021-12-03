package com.everest.airline.services;

import com.everest.airline.database.Data;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class SearchService {
    private List<Flight> getFlightsList;

    public List<Flight> flight(String source, String destination, String date) {

        getFlightsList = new ArrayList<>();
        Data.getFlights().parallelStream()
                .filter(f -> (f.getSource().equalsIgnoreCase(source) &&
                        f.getDestination().equalsIgnoreCase(destination) &&
                        f.getDepartureDate().equals(LocalDate.parse(date))))
                .forEach(f -> getFlightsList.add(f));
        return getFlightsList;

    }


}
