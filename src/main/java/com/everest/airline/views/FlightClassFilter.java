package com.everest.airline.views;

import com.everest.airline.model.Flight;
import com.everest.airline.views.EconomicClass;
import com.everest.airline.views.FlightClass;

import java.util.ArrayList;
import java.util.List;

public class FlightClassFilter {
    private String classType;

    private FlightClass test;

    public FlightClassFilter(String classType) {
        this.classType = classType;
    }

    public FlightClass filterClass(Flight flight) {

        switch (classType) {
            case "economic":
                test = new EconomicClass(flight);
                break;
            case "first":
                test = new FirstClass(flight);
        }

        return test;

    }
}