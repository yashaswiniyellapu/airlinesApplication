package com.everest.airline.views;

import com.everest.airline.model.Flight;

public abstract class FlightClass {
    private int seatsAvailable;
    protected int numberOfPassengers;

    public FlightClass(int seatsType, int numberOfPassengers) {
        this.seatsAvailable = seatsType;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDecrementedSeats() {
        if (seatsAvailable >= numberOfPassengers) {
            seatsAvailable = seatsAvailable - numberOfPassengers;
        }
        return Integer.toString(seatsAvailable);
    }

    abstract String updatedData(Flight flight, String decreasedSeats) throws Exception;
}
