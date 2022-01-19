
package com.everest.airline.views;

import com.everest.airline.enums.ClassType;
import com.everest.airline.price.TotalFareCalculation;

import java.time.LocalDate;

public class EconomicClass implements FlightClassType {
    private TotalFareCalculation totalFare;
    private int capacity;
    private int availableSeats;
    private LocalDate departureDate;
    private int passengerCount;

    public EconomicClass(int capacity, int availableSeats,LocalDate departureDate, int passengerCount){
        this.capacity = capacity;
        this.availableSeats = availableSeats;
        this.departureDate = departureDate;
        this.passengerCount = passengerCount;
    }

    @Override
    public double getFare() {
        return ClassType.economic.getFare();
    }

    @Override
    public double getClassFare() {
        double price;
        totalFare = new TotalFareCalculation(capacity, availableSeats, getFare(),departureDate);
        price = totalFare.getTotalClassFare();
        return price;
    }

    @Override
    public int getUpdatedData() {
        return availableSeats-passengerCount;
    }

//    @Override
//    public String getUpdatedData(Long flightNumber, int passengerCount) {
//        int seatsLeft = getSeatsLeft()-passengerCount;
//        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
//        return flight.toString(seatsLeft,flight.getFlightClass().getEconomicClassData().getSeatsLeft(),flight.getFlightClass().getEconomicClassData().getSeatsLeft(),availableSeatsLeft);
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
    public double getTotalFare() {
        return  getClassFare()*passengerCount;
    }
}
