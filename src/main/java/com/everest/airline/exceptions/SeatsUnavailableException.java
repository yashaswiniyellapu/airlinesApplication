package com.everest.airline.exceptions;

public class SeatsUnavailableException extends RuntimeException{
    public SeatsUnavailableException(String classType, int passengersCount)
    {
        super("Seats are unavailable in "+classType+" class with passengerCount "+ passengersCount);
    }
}
