package com.everest.airline.model;


<<<<<<< HEAD
import com.everest.airline.views.FlightClassData;
||||||| da26066 (Had public constructor for flightClasses)
import com.everest.airline.database.FlightDataAssign;
import com.everest.airline.views.FlightClassData;
=======
import com.everest.airline.database.FlightDataAssign;
>>>>>>> parent of da26066 (Had public constructor for flightClasses)

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
<<<<<<< HEAD
    private FlightClassData economicClass;
    private FlightClassData secondClass;
    private FlightClassData firstClass;

    public Flight(long number, String source, String destination, LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime, int availableSeats,FlightClassData economicClass,FlightClassData secondClass,FlightClassData firstClass) {
||||||| da26066 (Had public constructor for flightClasses)
    private FlightDataAssign flightClass;
    private FlightClassData economicClass;
    private FlightClassData secondClass;
    private FlightClassData firstClass;

    public Flight(long number, String source, String destination, LocalDate departureDate, LocalTime departureTime, LocalTime arrivalTime, int availableSeats,FlightClassData economicClass,FlightClassData secondClass,FlightClassData firstClass) {
=======
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
>>>>>>> parent of da26066 (Had public constructor for flightClasses)
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

<<<<<<< HEAD
//    public String toString(int economicClassSeats, int secondClassSeats, int firstClassSeats, int availableSeats) {
//        return getNumber() + "," + getSource() + "," + getDestination() +
//                "," + getDepartureDate() + "," + getDepartureTime() + "," +
//                getArrivalTime() + "," + availableSeats +
//                "," + economicClassSeats + "," + secondClassSeats + "," + firstClassSeats + "," +
//                flightClass.getEconomicClassData().getCapacity() + "," +
//                flightClass.getSecondClassData().getCapacity() + "," + flightClass.getFirstClassData().getCapacity();
//
//    }


    public FlightClassData getEconomicClass() {
        return economicClass;
    }

    public FlightClassData getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(FlightClassData secondClass) {
        this.secondClass = secondClass;
    }
||||||| da26066 (Had public constructor for flightClasses)
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
=======

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
>>>>>>> parent of da26066 (Had public constructor for flightClasses)

    }
}
