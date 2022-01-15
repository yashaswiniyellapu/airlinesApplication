package com.everest.airline.views;

import com.everest.airline.enums.FareType;
import com.everest.airline.model.Flight;
<<<<<<< HEAD
||||||| da26066 (Had public constructor for flightClasses)
import com.everest.airline.database.FlightClassDataTest;
=======
import com.everest.airline.database.FlightDataCollector;
>>>>>>> parent of da26066 (Had public constructor for flightClasses)
import com.everest.airline.price.TotalFareCalculation;

<<<<<<< HEAD
public class EconomicClass implements  FlightClassData {
||||||| da26066 (Had public constructor for flightClasses)
public class EconomicClass implements FlightClassDataTest, FlightClassData {
=======
public class EconomicClass implements FlightClassType, FlightDataCollector {
>>>>>>> parent of da26066 (Had public constructor for flightClasses)
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
<<<<<<< HEAD
//        int seatsLeft = getSeatsLeft()-passengerCount;
//        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
//        return flight.toString(seatsLeft,flight.getFlightClass().getEconomicClassData().getSeatsLeft(),flight.getFlightClass().getEconomicClassData().getSeatsLeft(),availableSeatsLeft);
        return null;
||||||| da26066 (Had public constructor for flightClasses)
        int seatsLeft = getSeatsLeft()-passengerCount;
        int availableSeatsLeft = flight.getAvailableSeats()-passengerCount;
        return flight.toString(seatsLeft,flight.getFlightClass().getEconomicClassData().getSeatsLeft(),flight.getFlightClass().getEconomicClassData().getSeatsLeft(),availableSeatsLeft);
=======
        String line = null;
        if (flightNumber == flight.getNumber()) {
            int availableSeats = flight.getAvailableSeats() - passengerCount;
            int seatsLeft = getSeatsLeft() - passengerCount;
            line = flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                    flight.getArrivalTime() + "," + availableSeats +
                    "," + seatsLeft + "," + flight.getSecondClassSeats() + "," + flight.getFirstClassSeats() + "," +
                    getCapacity() + "," + flight.getSecondClassCapacity() + "," + flight.getFirstClassCapacity();
        }
        return line;

>>>>>>> parent of da26066 (Had public constructor for flightClasses)
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


    public static FlightClassData getInstance() {
      return economicClassInstance;
    }
}
