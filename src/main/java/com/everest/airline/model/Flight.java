
package com.everest.airline.model;


import com.everest.airline.enums.ClassType;
import com.everest.airline.views.FlightClassType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Flight {
    private long number;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int availableSeats;
    private FlightClassType economicClass;
    private FlightClassType firstClass;
    private FlightClassType secondClass;

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
        return availableSeats;
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

    public void setSecondClass(FlightClassType secondClass) {
        this.secondClass = secondClass;
    }

    //
//    public String toString(int economicClassSeats, int secondClassSeats, int firstClassSeats, int availableSeats) {
//        return getNumber() + "," + getSource() + "," + getDestination() +
//                "," + getDepartureDate() + "," + getDepartureTime() + "," +
//                getArrivalTime() + "," + availableSeats +
//                "," + economicClassSeats + "," + secondClassSeats + "," + firstClassSeats + "," +
//                flightClass.getEconomicClassData().getCapacity() + "," +
//                flightClass.getSecondClassData().getCapacity() + "," + flightClass.getFirstClassData().getCapacity();

//}
    public  Set<Map.Entry<ClassType, FlightClassType>> FlightClassID()
    {
        HashMap<ClassType,FlightClassType> classes = new HashMap<>();
        classes.put(ClassType.ECONOMIC,economicClass);
        classes.put(ClassType.SECOND,secondClass);
        classes.put(ClassType.FIRST,firstClass);
        return classes.entrySet();
    }


}
