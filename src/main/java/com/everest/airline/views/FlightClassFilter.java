package com.everest.airline.views;

import com.everest.airline.model.Flight;

public class FlightClassFilter {
    private String classType;

    private FlightClassData type;

    public FlightClassFilter(String classType) {
        this.classType = classType;
    }

    public FlightClassData filterClass(Flight flight) {

        switch (classType) {
            case "economic":
                type = new EconomicClass(flight);
                break;
            case "first":
                type = new FirstClass(flight);
                break;
            case "second":
                type = new SecondClass(flight);
                break;
        }

        return type;

    }
}