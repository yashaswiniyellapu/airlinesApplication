package com.everest.airline.comparator;

import com.everest.airline.model.Flight;

import java.util.Comparator;

public class FlightComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight f1, Flight f2) {
        return Long.compare(f1.getNumber(),f2.getNumber());
    }
}
