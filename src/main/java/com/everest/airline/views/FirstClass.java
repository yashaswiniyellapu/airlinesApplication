package com.everest.airline.views;

import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;

public class FirstClass implements FlightClassType {
    private Flight flight;

    public FirstClass(Flight flight) {
        this.flight = flight;
    }

    @Override
    public double getFare() {
        return FareType.FIRST.getFare();
    }

    @Override
    public double getTotalFare() {
        double price = 0;
        int capacity = flight.getFirstClassCapacity();
        double result1 = capacity * 0.3;
        double result2 = capacity * 0.5;
        double result3 = capacity * 0.75;
        int availableSeats = flight.getFirstClassSeats();
        if (availableSeats <= (int) result1) {
            price = getFare();
        } else if (availableSeats > (int) result1 && availableSeats <= (int) result2) {
            price = getFare() + (getFare() * 0.2);
        } else if (availableSeats > (int) result2 && availableSeats <= (int) result3) {
            price = getFare() + (getFare() * 0.35);
        } else if (availableSeats > (int) result3 && availableSeats <= capacity) {
            price = getFare() + (getFare() * 0.50);
        }

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
