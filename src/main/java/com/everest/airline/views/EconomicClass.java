package com.everest.airline.views;

import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;

public class EconomicClass implements  FlightClassData {
    private Flight flight;
    private TotalFareCalculation totalFare;
    private int capacity;
    private int seatsLeft;

//    public EconomicClass(Flight flight) {
//        this.flight = flight;
//    }
   private EconomicClass(){}

    @Override
    public double getFare() {
        return FareType.ECONOMIC.getFare();
    }

    @Override
    public double getTotalFare() {
        int capacity = getCapacity();
        int availableSeats =getSeatsLeft();
        double price;
        totalFare = new TotalFareCalculation(capacity, availableSeats, getFare(), flight.getDepartureDate());
        price = totalFare.getTotalClassFare();
        return price;
    }

    @Override
    public String getUpdatedData(Long flightNumber, int passengerCount) {
//        int seatsLeft = getSeatsLeft()-passengerCount;
//        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
//        return flight.toString(seatsLeft,flight.getFlightClass().getEconomicClassData().getSeatsLeft(),flight.getFlightClass().getEconomicClassData().getSeatsLeft(),availableSeatsLeft);
        return null;
    }

    @Override
    public boolean validateData(int passengerCount) {
        return passengerCount <= getSeatsLeft();
    }

    @Override
    public int getSeatsLeft() {
        System.out.println("getSeatsLeft "+ seatsLeft);
        return seatsLeft;
    }

    @Override
    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft=seatsLeft;
        System.out.println("seatsLeft "+ seatsLeft+ " this.seatsLeft "+ this.seatsLeft);

    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity=capacity;

    }


    public static FlightClassData getInstance() {
      return economicClassInstance;
    }
}
