package com.everest.airline.views;

import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;

public class EconomicClass implements FlightClassType {
    private Flight flight;
    private TotalFareCalculation totalFare;

    public EconomicClass(Flight flight) {
        this.flight = flight;
    }

    @Override
    public double getFare() {
        return FareType.ECONOMIC.getFare();
    }

    @Override
    public double getTotalFare() {
        int capacity = flight.getEconomicCapacity();
        int availableSeats = flight.getEconomicClassSeats();
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
