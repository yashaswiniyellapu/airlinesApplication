package com.everest.airline.views;

import com.everest.airline.model.Flight;

public class EconomicClass extends FlightClass {
    public EconomicClass(int availableSeats, int numberOfPassengers) {
        super(availableSeats, numberOfPassengers);
    }

    @Override
    String updatedData(Flight flight, String decreasedSeats) {
        int availableSeats = flight.getAvailableSeats() - numberOfPassengers;
        return flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                flight.getArrivalTime() + "," + availableSeats +
                "," + decreasedSeats + "," + flight.getSecondClassSeats() + "," + flight.getFirstClassSeats()+","+
                flight.getEconomicCapacity()+","+ flight.getSecondClassCapacity()+","+flight.getFirstClassCapacity();
    }
}
