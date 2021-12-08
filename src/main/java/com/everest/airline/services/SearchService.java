package com.everest.airline.services;

import com.everest.airline.database.Data;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SearchService {
    private List<Flight> getFlightsList;

    public List<Flight> flight(String source, String destination, String date) {

        return Data.getData().stream()
                .filter(f -> (f.getSource().equalsIgnoreCase(source) &&
                        f.getDestination().equalsIgnoreCase(destination) &&
                        f.getDepartureDate().equals(LocalDate.parse(date))))
                .collect(Collectors.toList());

    }


}
