package com.everest.airline.views;

import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
import com.everest.airline.price.TotalFareCalculation;

<<<<<<< HEAD
public class SecondClass implements FlightClassData {
||||||| da26066 (Had public constructor for flightClasses)
public class SecondClass implements FlightClassData, FlightClassDataTest {
=======
public class SecondClass implements FlightClassType {
>>>>>>> parent of da26066 (Had public constructor for flightClasses)
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
<<<<<<< HEAD
        int seatsLeft = getSeatsLeft()-passengerCount;
        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
        return flight.toString(flight.getFlightClass().getEconom icClassData().getSeatsLeft(),seatsLeft,flight.getFlightClass().getFirstClassData().getSeatsLeft(),availableSeatsLeft);
||||||| da26066 (Had public constructor for flightClasses)
        int seatsLeft = getSeatsLeft()-passengerCount;
        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
        return flight.toString(flight.getFlightClass().getEconomicClassData().getSeatsLeft(),seatsLeft,flight.getFlightClass().getFirstClassData().getSeatsLeft(),availableSeatsLeft);
=======
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
>>>>>>> parent of da26066 (Had public constructor for flightClasses)
    }

    @Override
    public boolean validateData(int passengerCount) {
        if (passengerCount <= flight.getFirstClassSeats()) {
            return true;
        }
        return false;
    }
}
