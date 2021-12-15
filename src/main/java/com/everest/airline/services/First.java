package com.everest.airline.services;

import com.everest.airline.model.Flight;

public class First extends FlightClass {
    public First(int seatsType, int numberOfPassengers) {
        super(seatsType, numberOfPassengers);
    }

    @Override
    String updatedData(Flight flight, String decreasedSeats) {
        int availableSeats = flight.getAvailableSeats() - numberOfPassengers;
        return flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                flight.getArrivalTime() + "," + availableSeats +
                "," + flight.getEconomicSeats() + "," + flight.getSecondClassSeats() + "," + decreasedSeats;
    }
}
