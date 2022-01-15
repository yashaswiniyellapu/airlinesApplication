package com.everest.airline.views;

import com.everest.airline.database.FlightClassDataTest;
import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;

public class FirstClass implements FlightClassData, FlightClassDataTest {
    private Flight flight;
    private TotalFareCalculation totalFare;
    private int capacity;
    private int seatsLeft;


    public FirstClass(Flight flight) {
        this.flight = flight;
    }

    public FirstClass() {

    }

    @Override
    public double getFare() {
        return FareType.FIRST.getFare();
    }

    @Override
    public double getTotalFare() {
        int capacity = getCapacity();
        int availableSeats = getSeatsLeft();
        double price;
        totalFare = new TotalFareCalculation(capacity, availableSeats, getFare(), flight.getDepartureDate());
        price = totalFare.getTotalClassFare();
        return price;
    }
    public String getUpdatedData(Long flightNumber, int passengerCount) {
        int seatsLeft = getSeatsLeft()-passengerCount;
        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
        return flight.toString(flight.getFlightClass().getEconomicClassData().getSeatsLeft(),flight.getFlightClass().getSecondClassData().getSeatsLeft(),seatsLeft,availableSeatsLeft);
    }


    @Override
    public boolean validateData(int passengerCount) {
        if (passengerCount <= getSeatsLeft()) {
            return true;
        }
        return false;
    }

    @Override
    public int getSeatsLeft() {
        return seatsLeft;
    }

    @Override
    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft=seatsLeft;

    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity=capacity;

    }
}
