package com.everest.airline.views;

import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;

public class EconomicClass implements FlightClass {
    private Flight flight;

    public EconomicClass(Flight flight) {
        this.flight = flight;
    }

    @Override
    public double getFare() {
        return FareType.ECONOMIC.getFare();
    }

    @Override
    public double getTotalFare() {
        double price = 0;
        double result1 = flight.getEconomicCapacity() * 0.3;
        double result2 = flight.getEconomicCapacity() * 0.5;
        double result3 = flight.getEconomicCapacity() * 0.75;
        if (flight.getEconomicClassSeats() <= (int) result1) {
            price = getFare();
        } else if (flight.getEconomicClassSeats() > (int) result1 && flight.getEconomicClassSeats() <= (int) result2) {
            price = getFare() + (getFare() * 0.2);
        } else if (flight.getEconomicClassSeats() > (int) result2 && flight.getEconomicClassSeats() <= (int) result3) {
            price = getFare() + (getFare() * 0.35);
        } else if (flight.getEconomicClassSeats() > (int) result3 && flight.getEconomicClassSeats() <= flight.getEconomicCapacity()) {
            price = getFare() + (getFare() * 0.50);
        }

        return price;
    }

    @Override
    public String getUpdatedData(Long flightNumber, int passengerCount) {
        String line = null;
        if (flightNumber == flight.getNumber()) {
            int availableSeats = flight.getAvailableSeats() - passengerCount;
            int seatsLeft = flight.getEconomicClassSeats() - passengerCount;
            line = flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                    flight.getArrivalTime() + "," + availableSeats +
                    "," + seatsLeft + "," + flight.getSecondClassSeats() + "," + flight.getFirstClassSeats() + "," +
                    flight.getEconomicCapacity() + "," + flight.getSecondClassCapacity() + "," + flight.getFirstClassCapacity();
        }
        return line;

    }

    @Override
    public boolean validateData(int passengerCount) {
        if (passengerCount <= flight.getEconomicClassSeats()) {
            return true;
        }
        return false;
    }
}
