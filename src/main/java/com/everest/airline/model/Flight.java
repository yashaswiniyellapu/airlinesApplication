
package com.everest.airline.model;


import com.everest.airline.enums.ClassType;
import com.everest.airline.views.FlightClassType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Flight {
    private long number;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private static FlightClassType economicClass;
    private static FlightClassType firstClass;
    private static FlightClassType secondClass;

    public Flight(long number, String source, String destination, LocalDate departureDate,LocalTime departureTime,LocalTime arrivalTime, FlightClassType economicClass, FlightClassType secondClass, FlightClassType firstClass) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.economicClass = economicClass;
        this.secondClass = secondClass;
        this.firstClass = firstClass;
    }

    public long getNumber() {
        return number;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public int getAvailableSeats() {
        return economicClass.getSeatsLeft()+firstClass.getSeatsLeft()+secondClass.getSeatsLeft();
    }

    public FlightClassType getEconomicClass() {
        return economicClass;
    }

    public FlightClassType getFirstClass() {
        return firstClass;
    }

    public FlightClassType getSecondClass() {
        return secondClass;
    }


    public  String toString(int passengerCount, String classType) {
        int economicClassSeats=0;
        int secondClassSeats=0;
        int firstClassSeats=0;
        switch (classType) {
            case "economic":
                economicClassSeats = economicClass.getSeatsLeft() - passengerCount;
                secondClassSeats = secondClass.getSeatsLeft();
                firstClassSeats = firstClass.getSeatsLeft();
                break;
            case "first":
                economicClassSeats = economicClass.getSeatsLeft();
                secondClassSeats = secondClass.getSeatsLeft() - passengerCount;
                firstClassSeats = firstClass.getSeatsLeft();
                break;
            case "second":

                economicClassSeats = economicClass.getSeatsLeft();
                secondClassSeats = secondClass.getSeatsLeft();
                firstClassSeats = firstClass.getSeatsLeft() - passengerCount;
                break;
            default:
                System.out.println("enter correct type");
        }
        return getNumber() + "," + getSource() + "," + getDestination() +
                "," + getDepartureDate() + "," + getDepartureTime() + "," +
                getArrivalTime() + "," + (getAvailableSeats()-passengerCount) +
                "," + economicClassSeats + "," + secondClassSeats + "," + firstClassSeats + "," +
                economicClass.getCapacity() + "," +
                secondClass.getCapacity() + "," + firstClass.getCapacity();

}

    public FlightClassType flightClassesData(String classType)
    {
        HashMap<ClassType,FlightClassType> classes = new HashMap<>();
        classes.put(ClassType.economic,economicClass);
        classes.put(ClassType.second,secondClass);
        classes.put(ClassType.first,firstClass);
        return classes.get(ClassType.valueOf(classType));
    }
}
