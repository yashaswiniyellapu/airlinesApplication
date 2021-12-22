package com.everest.airline.views;

import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;

public class SecondClass implements FlightClassType {
    private Flight flight;
    private TotalFareCalculation totalFare;

    public SecondClass(Flight flight) {
        this.flight = flight;
    }

    @Override
    public double getFare() {
        return FareType.SECOND.getFare();
    }

    @Override
    public double getTotalFare() {
        int capacity = flight.getSecondClassCapacity();
        int availableSeats = flight.getSecondClassSeats();
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
            int seatsLeft = flight.getSecondClassSeats() - passengerCount;
            line = flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                    flight.getArrivalTime() + "," + availableSeats +
                    "," + flight.getEconomicClassSeats() + "," + seatsLeft + "," + flight.getFirstClassSeats() + "," +
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
