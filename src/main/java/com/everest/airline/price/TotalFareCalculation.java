package com.everest.airline.price;

import com.everest.airline.enums.ClassType;
import com.everest.airline.views.FlightClassType;

import java.time.LocalDate;
import java.time.Period;

public class TotalFareCalculation {
    private int availableSeats;
    private int capacity;
    private double fare;
    private LocalDate departureDate;
    private FlightClassType flightClass;

    public TotalFareCalculation(FlightClassType flightClass, LocalDate departureDate, String classType) {
        this.flightClass = flightClass;
        this.departureDate = departureDate;
        fare = ClassType.valueOf(classType).getFare();
        byDays();
    }

    public double byAvailableSeats() {
        double price;
        if (flightClass.getSeatsLeft() >= flightClass.getCapacity() * 0.7) {
            price = fare;
        } else if (flightClass.getSeatsLeft() > flightClass.getCapacity() * 0.5
                && flightClass.getSeatsLeft() <= flightClass.getCapacity() * 0.7) {
            price = fare + (fare * 0.2);
        } else if (flightClass.getSeatsLeft() > flightClass.getCapacity() * 0.25
                && flightClass.getSeatsLeft() <= flightClass.getCapacity() * 0.5) {
            price = fare + (fare * 0.35);
        } else {
            price = fare + (fare * 0.50);
        }
        return price;
    }

    public double byDays() {
        double price = 0;
        int totalNumberOfDays;
        double priceByAvailableSeats = byAvailableSeats();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(departureDate, currentDate);
        int numberOfDays = period.getDays();
        if (numberOfDays < 0) {
            totalNumberOfDays = (int) Math.copySign(numberOfDays, 1);
        } else {
            totalNumberOfDays = numberOfDays;
        }
        if (totalNumberOfDays > 0 && totalNumberOfDays <= 3) {
            int day = 3 - totalNumberOfDays + 1;
            price = priceByAvailableSeats + (priceByAvailableSeats * day * 0.02);
        } else if (totalNumberOfDays > 3 && totalNumberOfDays <= 10) {
            int day = 10 - totalNumberOfDays + 1;
            price = priceByAvailableSeats + (priceByAvailableSeats * day * 0.02);
        } else if (totalNumberOfDays > 10) {
            price = priceByAvailableSeats;
        }
        return price;
    }
}