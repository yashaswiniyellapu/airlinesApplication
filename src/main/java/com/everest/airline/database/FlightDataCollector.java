package com.everest.airline.database;

public interface FlightDataCollector {

    int getSeatsLeft();

    void setSeatsLeft(int seatsLeft);

    int getCapacity();

    void setCapacity(int capacity);


}
