package com.everest.airline.services;

import com.everest.airline.model.Flight;

import java.util.List;

public final class Cabin {
    private String classType;
    private String numberOfPassengers;
    private String decreasedSeats;
    private String line;

    public Cabin(String classType, String numberOfPassengers) {
        this.classType = classType;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String seatsLeft(List<Flight> flightData) {
        for (Flight flight : flightData) {
            switch (classType) {
                case "economic":
                    FlightClass economicType = new Economic(flight.getEconomicSeats(), Integer.parseInt(numberOfPassengers));
                    decreasedSeats = economicType.getDecrementedSeats();
                    line = economicType.updatedData(flight, decreasedSeats);
                    break;
                case "second":
                    FlightClass secondType = new Second(flight.getSecondClassSeats(), Integer.parseInt(numberOfPassengers));
                    decreasedSeats = secondType.getDecrementedSeats();
                    line = secondType.updatedData(flight, decreasedSeats);
                    break;
                case "first":
                    FlightClass firstType = new First(flight.getFirstClassSeats(), Integer.parseInt(numberOfPassengers));
                    decreasedSeats = firstType.getDecrementedSeats();
                    line = firstType.updatedData(flight, decreasedSeats);
                    break;

            }
        }
        return line;
    }

}