package com.everest.airline.model;


import com.everest.airline.database.FlightDataAssign;

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
    private FlightDataAssign economicClass;
    private FlightDataAssign firstClass;
    private FlightDataAssign secondClass;

//    public Flight(long number, String source, String destination, LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime, int availableSeats, int economicSeats, int secondClassSeats, int firstClassSeats, int economicCapacity, int secondClassCapacity, int firstClassCapacity) {
//        this.number = number;
//        this.source = source;
//        this.destination = destination;
//        this.departureDate = departureDate;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//        this.availableSeats = availableSeats;
//        this.secondClassSeats = secondClassSeats;
//        this.firstClassSeats = firstClassSeats;
//        this.economicClassSeats = economicSeats;
//        this.economicCapacity = economicCapacity;
//        this.secondClassCapacity = secondClassCapacity;
//        this.firstClassCapacity = firstClassCapacity;
//    }


    public Flight(long number, String source, String destination, LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime, int availableSeats, FlightDataAssign economicClass) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.economicClass = economicClass;
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


    public FlightDataAssign getEconomicClass() {
        return economicClass;
    }
    public String toString(int economicClassSeats, int secondClassSeats, int firstClassSeats, int availableSeats) {
        return getNumber() + "," + getSource() + "," + getDestination() +
                "," + getDepartureDate() + "," + getDepartureTime() + "," +
                getArrivalTime() + "," + availableSeats +
                "," + economicClassSeats + "," + secondClassSeats + "," + firstClassSeats+ "," +
                economicClass.getEconomicClassData().getCapacity() + "," +
                secondClass.getEconomicClassData().getCapacity() + "," + firstClass.getEconomicClassData().getCapacity();

    }
}
