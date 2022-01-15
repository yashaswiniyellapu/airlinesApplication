package com.everest.airline.views;

import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;

<<<<<<< HEAD
public class FirstClass implements FlightClassData {
||||||| da26066 (Had public constructor for flightClasses)
public class FirstClass implements FlightClassData, FlightClassDataTest {
=======
public class FirstClass implements FlightClassType {
>>>>>>> parent of da26066 (Had public constructor for flightClasses)
    private Flight flight;
    private TotalFareCalculation totalFare;


    public FirstClass(Flight flight) {
        this.flight = flight;
    }

    @Override
    public double getFare() {
        return FareType.FIRST.getFare();
    }

    @Override
    public double getTotalFare() {
        int capacity = flight.getFirstClassCapacity();
        int availableSeats = flight.getFirstClassSeats();
        double price;
        totalFare = new TotalFareCalculation(capacity, availableSeats, getFare(), flight.getDepartureDate());
        price = totalFare.getTotalClassFare();
        return price;
    }

    @Override
    public String getUpdatedData(Long flightNumber, int passengerCount) {
        String line = null;
        if (flightNumber == flight.getNumber()) {
            int availableSeats = flight.getAvailableSeats() - passengerCount;
            int seatsLeft = flight.getFirstClassSeats() - passengerCount;
            line = flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                    flight.getArrivalTime() + "," + availableSeats +
                    "," + flight.getEconomicClassSeats() + "," + flight.getSecondClassSeats() + "," + seatsLeft + "," +
                    flight.getEconomicCapacity() + "," + flight.getSecondClassCapacity() + "," + flight.getFirstClassCapacity();
        }
        return line;
    }

    @Override
    public boolean validateData(int passengerCount) {
        if (passengerCount <= flight.getFirstClassSeats()) {
            return true;
        }
        return false;
    }
}
