package com.everest.airline.exceptions;

public class FlightNotFoundException extends RuntimeException{
    public  FlightNotFoundException()
    {
        super("Failed to find flight, Please check with user details");
    }
}
