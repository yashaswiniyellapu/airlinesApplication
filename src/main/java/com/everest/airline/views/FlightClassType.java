package com.everest.airline.views;


public interface FlightClassType {


    double getClassFare();

    int getSeatsLeft();

    int getCapacity();

    double getTotalFare();

    void setClassFare(double fare);

    void setTotalFare(double fare);


}
