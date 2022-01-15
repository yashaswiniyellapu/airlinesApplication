package com.everest.airline.database;

import com.everest.airline.views.EconomicClass;

public class FlightDataAssign {
    private int economicClassSeats;
    private int firstClassSeats;
    private int secondClassSeats;
    private int economicCapacity;
    private int secondClassCapacity;
    private int firstClassCapacity;
    private FlightDataCollector economicClass;
    private FlightDataCollector firstClass;
    private FlightDataCollector secondClass;


    public FlightDataAssign(int economicClassSeats, int firstClassSeats, int secondClassSeats, int economicCapacity, int secondClassCapacity, int firstClassCapacity) {
        this.economicClassSeats = economicClassSeats;
        this.firstClassSeats = firstClassSeats;
        this.secondClassSeats = secondClassSeats;
        this.economicCapacity = economicCapacity;
        this.secondClassCapacity = secondClassCapacity;
        this.firstClassCapacity = firstClassCapacity;
    }
    public FlightDataCollector getEconomicClassData() {
        economicClass = new EconomicClass();
        economicClass.setCapacity(economicCapacity);
        economicClass.setSeatsLeft(economicClassSeats);
        return economicClass;
    }
}
