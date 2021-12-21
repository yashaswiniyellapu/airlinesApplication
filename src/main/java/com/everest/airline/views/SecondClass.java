package com.everest.airline.views;

import com.everest.airline.model.Flight;
import com.everest.airline.views.FlightClass;

public class SecondClass extends FlightClass {
    public SecondClass(int seatsType, int numberOfPassengers) {
        super(seatsType, numberOfPassengers);
    }

    @Override
    String updatedData(Flight flight, String decreasedSeats) {
        int availableSeats = flight.getAvailableSeats() - numberOfPassengers;
        return flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                flight.getArrivalTime() + "," + availableSeats +
                "," + flight.getEconomicClassSeats() + "," + decreasedSeats + "," + flight.getFirstClassSeats()+","+
                flight.getEconomicCapacity()+","+ flight.getSecondClassCapacity()+","+flight.getFirstClassCapacity();
    }
}
