package com.everest.airline.views;

import com.everest.airline.database.FlightClassDataTest;
import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;

public class SecondClass implements FlightClassData, FlightClassDataTest {
    private Flight flight;
    private TotalFareCalculation totalFare;
    private int capacity;
    private int seatsLeft;

    public SecondClass(Flight flight) {
        this.flight = flight;
    }

    public SecondClass() {

    }

    @Override
    public double getFare() {
        return FareType.SECOND.getFare();
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

    @Override
    public String getUpdatedData(Long flightNumber, int passengerCount) {
        int seatsLeft = getSeatsLeft()-passengerCount;
        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
        return flight.toString(flight.getFlightClass().getEconomicClassData().getSeatsLeft(),seatsLeft,flight.getFlightClass().getFirstClassData().getSeatsLeft(),availableSeatsLeft);
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
