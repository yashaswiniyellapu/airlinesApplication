
package com.everest.airline.model;


import com.everest.airline.enums.ClassType;
import com.everest.airline.views.FlightClassType;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;


public class Flight {
    private long number;
    private String source;
    private String destination;
    private Date departureDate;
    private Time departureTime;
    private Time arrivalTime;
    private static FlightClassType economicClass = new FlightClassType();
    private static FlightClassType firstClass = new FlightClassType();
    private static FlightClassType secondClass = new FlightClassType();

    public Flight() {
    }

    public static void setEconomicClass(FlightClassType economicClass) {
        Flight.economicClass = economicClass;
    }

    public static void setFirstClass(FlightClassType firstClass) {
        Flight.firstClass = firstClass;
    }

    public static void setSecondClass(FlightClassType secondClass) {
        Flight.secondClass = secondClass;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public int getAvailableSeats() {
        return economicClass.getSeatsLeft() + firstClass.getSeatsLeft() + secondClass.getSeatsLeft();
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

    public FlightClassType flightClassesData(String classType) {
        HashMap<ClassType, FlightClassType> classes = new HashMap<>();
        classes.put(ClassType.economic, economicClass);
        classes.put(ClassType.second, secondClass);
        classes.put(ClassType.first, firstClass);

        return classes.get(ClassType.valueOf(classType));
    }
}
