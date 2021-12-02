package com.everest.airline;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.everest.airline.Data.flights;

public class SearchService {
    private String source;
    private String destination;
    private String date;
    private List<Flight> getFlightsList;

    public SearchService(String source, String destination,String date) {
        this.source = source;
        this.destination = destination;
        this.date = date;
    }


    public List<Flight> sortByPlace() {
        getFlightsList = new ArrayList<>();
       flights.parallelStream()
                .filter(f -> (f.getSource().equalsIgnoreCase(source) &&
                        f.getDestination().equalsIgnoreCase(destination)&&
                        f.getDepartureDate().equals(LocalDate.parse(date))))
                .forEach(f->getFlightsList.add(f));
       return getFlightsList;

    }


}
