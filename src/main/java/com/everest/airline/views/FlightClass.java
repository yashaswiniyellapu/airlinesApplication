package com.everest.airline.views;

public interface FlightClass {

    public double getFare();
    public  double getTotalFare();
    public  String getUpdatedData(Long flightNumber, int passengerCount);
    public  boolean validateData(int passengerCount);
}
