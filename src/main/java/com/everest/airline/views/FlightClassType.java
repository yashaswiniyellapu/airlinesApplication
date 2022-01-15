package com.everest.airline.views;


public interface FlightClassType {

    double getFare();

    double getTotalFare();

    String getUpdatedData(Long flightNumber, int passengerCount);

    boolean validateData(int passengerCount);


}
