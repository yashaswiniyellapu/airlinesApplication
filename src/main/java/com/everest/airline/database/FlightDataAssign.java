package com.everest.airline.database;

import com.everest.airline.views.EconomicClass;
import com.everest.airline.views.FirstClass;
import com.everest.airline.views.SecondClass;

public class FlightDataAssign {
    private int economicClassSeats;
    private int firstClassSeats;
    private int secondClassSeats;
    private int economicCapacity;
    private int secondClassCapacity;
    private int firstClassCapacity;
    private FlightClassDataTest economicClass;
    private FlightClassDataTest firstClass;
    private FlightClassDataTest secondClass;


    public FlightDataAssign(int economicClassSeats, int firstClassSeats, int secondClassSeats, int economicCapacity, int secondClassCapacity, int firstClassCapacity) {
        this.economicClassSeats = economicClassSeats;
        this.firstClassSeats = firstClassSeats;
        this.secondClassSeats = secondClassSeats;
        this.economicCapacity = economicCapacity;
        this.secondClassCapacity = secondClassCapacity;
        this.firstClassCapacity = firstClassCapacity;
    }
    public FlightClassDataTest getEconomicClassData() {
        economicClass = new EconomicClass();
        economicClass.setCapacity(economicCapacity);
        economicClass.setSeatsLeft(economicClassSeats);
        return economicClass;
    }
    public FlightClassDataTest getFirstClassData()
    {
        firstClass = new FirstClass();
        firstClass.setCapacity(firstClassCapacity);
        economicClass.setSeatsLeft(firstClassSeats);
        return firstClass;
    }
    public FlightClassDataTest getSecondClassData()
    {
        secondClass = new SecondClass();
        firstClass.setCapacity(secondClassCapacity);
        economicClass.setSeatsLeft(secondClassSeats);
        return secondClass;
    }
}
