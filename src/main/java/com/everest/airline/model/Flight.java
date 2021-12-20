package com.everest.airline.model;


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
    private int economicClassSeats;
    private int firstClassSeats;
    private int secondClassSeats;
    private double economicFare;
    private double secondClassFare;
    private double firstClassFare;
    private int economicCapacity;
    private int secondClassCapacity;
    private int firstClassCapacity;

    public Flight(long number, String source, String destination, LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime, int availableSeats, int economicSeats, int secondClassSeats, int firstClassSeats,int economicCapacity,int secondClassCapacity,int firstClassCapacity) {
        this.number = number;
        this.source = source;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = availableSeats;
        this.secondClassSeats = secondClassSeats;
        this.firstClassSeats = firstClassSeats;
        this.economicClassSeats = economicSeats;
        this.economicCapacity=economicCapacity;
        this.secondClassCapacity=secondClassCapacity;
        this.firstClassCapacity=firstClassCapacity;
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

    public int getEconomicClassSeats() {
        return economicClassSeats;
    }

    public int getFirstClassSeats() {
        return firstClassSeats;
    }

    public int getSecondClassSeats() {
        return secondClassSeats;
    }

    public double getEconomicClassFare() {
        return economicFare = 170.0;
    }

    public double getSecondClassFare() {
        return secondClassFare = 200.0;
    }

    public double getFirstClassFare() {
        return firstClassFare = 350.0;
    }

    public int getEconomicCapacity() {
        return economicCapacity;
    }

    public int getSecondClassCapacity() {
        return secondClassCapacity;
    }

    public int getFirstClassCapacity() {
        return firstClassCapacity;
    }
}
