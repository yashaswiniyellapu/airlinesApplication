package com.everest.airline.views;

public interface FlightClassData {

    double getFare();

    double getTotalFare();

    String getUpdatedData(Long flightNumber, int passengerCount);

    boolean validateData(int passengerCount);

    int getSeatsLeft();

    void setSeatsLeft(int seatsLeft);

    int getCapacity();

    void setCapacity(int capacity);
}
