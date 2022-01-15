package com.everest.airline.model;


import com.everest.airline.database.FlightDataAssign;
import com.everest.airline.views.FlightClassData;

import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private long number;
    private String source;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int availableSeats;
    private FlightDataAssign flightClass;
    private FlightClassData economicClass;
    private FlightClassData secondClass;
    private FlightClassData firstClass;

    public Flight(long number, String source, String destination, LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime, int availableSeats,FlightClassData economicClass,FlightClassData secondClass,FlightClassData firstClass) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
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

    public String toString(int economicClassSeats, int secondClassSeats, int firstClassSeats, int availableSeats) {
        return getNumber() + "," + getSource() + "," + getDestination() +
                "," + getDepartureDate() + "," + getDepartureTime() + "," +
                getArrivalTime() + "," + availableSeats +
                "," + economicClassSeats + "," + secondClassSeats + "," + firstClassSeats + "," +
                flightClass.getEconomicClassData().getCapacity() + "," +
                flightClass.getSecondClassData().getCapacity() + "," + flightClass.getFirstClassData().getCapacity();

    }

    public FlightDataAssign getFlightClass() {
        return flightClass;
    }

    public FlightClassData getEconomicClass() {
        return economicClass;
    }

    public FlightClassData getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(FlightClassData secondClass) {
        this.secondClass = secondClass;
    }

    public FlightClassData getFirstClass() {
        return firstClass;
    }
}
