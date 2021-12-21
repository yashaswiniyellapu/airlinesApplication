package com.everest.airline.services;

import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

@Component

public final class FlightClassFliter {
    private String decreasedSeats;
    private String line;


    public String seatsLeft(String classType, String numberOfPassengers, Flight flight) throws Exception {
        switch (classType) {
            case "economic":
                FlightClass economicType = new EconomicClass(flight.getEconomicClassSeats(), Integer.parseInt(numberOfPassengers));
                decreasedSeats = economicType.getDecrementedSeats();
                line = economicType.updatedData(flight, decreasedSeats);
                break;
            case "second":
                FlightClass secondType = new SecondClass(flight.getSecondClassSeats(), Integer.parseInt(numberOfPassengers));
                decreasedSeats = secondType.getDecrementedSeats();
                line = secondType.updatedData(flight, decreasedSeats);
                break;
            case "first":
                FlightClass firstType = new FirstClass(flight.getFirstClassSeats(), Integer.parseInt(numberOfPassengers));
                decreasedSeats = firstType.getDecrementedSeats();
                line = firstType.updatedData(flight, decreasedSeats);
                break;

        }
        return line;
    }

}