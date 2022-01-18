package com.everest.airline.views;

import com.everest.airline.enums.ClassType;
import com.everest.airline.price.TotalFareCalculation;

import java.time.LocalDate;

public class SecondClass implements FlightClassType {
    private TotalFareCalculation totalFare;
    private int capacity;
    private int availableSeats;
    private LocalDate departureDate;


    public SecondClass(int capacity, int availableSeats) {
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }

    @Override
    public double getFare() {
        return ClassType.SECOND.getFare();
    }

    @Override
    public double getTotalFare() {
        double price;
        totalFare = new TotalFareCalculation(capacity, availableSeats, getFare(), departureDate);
        price = totalFare.getTotalClassFare();
        return price;
    }

//    @Override
//    public String getUpdatedData(Long flightNumber, int passengerCount) {
//        int seatsLeft = getSeatsLeft()-passengerCount;
//        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
//        return flight.toString(flight.getFlightClass().getEconomicClassData().getSeatsLeft(),seatsLeft,flight.getFlightClass().getFirstClassData().getSeatsLeft(),availableSeatsLeft);
//    }

    @Override
    public boolean validateData(int passengerCount) {
        return passengerCount <= getSeatsLeft();
    }

    @Override
    public int getSeatsLeft() {
        return availableSeats;
    }


    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setDepartureDate(LocalDate date) {
        departureDate = date;
    }

}