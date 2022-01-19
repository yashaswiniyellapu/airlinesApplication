package com.everest.airline.views;


import java.time.LocalDate;

public interface FlightClassType {

    double getFare();

    double getClassFare();

 int getUpdatedData();

    boolean validateData(int passengerCount);

        int getSeatsLeft();

        int getCapacity();
        double getTotalFare();







}
