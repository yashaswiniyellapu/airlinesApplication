package com.everest.airline.views;


import java.time.LocalDate;

public interface FlightClassType {

    double getFare();

    double getTotalFare();

//    String getUpdatedData(Long flightNumber, int passengerCount);

    boolean validateData(int passengerCount);

        int getSeatsLeft();

        int getCapacity();
        void setDepartureDate(LocalDate date);







}
