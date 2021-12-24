package com.everest.airline.price;

import java.time.LocalDate;
import java.time.Period;

public class TotalFareCalculation {
    private int availableSeats;
    private int capacity;
    private double fare;
    private LocalDate departureDate;

    public TotalFareCalculation(int capacity, int availableSeats, double fare, LocalDate departureDate) {
        this.availableSeats = availableSeats;
        this.capacity = capacity;
        this.fare = fare;
        this.departureDate = departureDate;
    }

    public double _byAvailableSeats() {
        double price;
        if (availableSeats >= capacity*0.7) {
            price = fare;
        } else if (availableSeats > capacity*0.5 && availableSeats <= capacity*0.7) {
            price = fare + (fare * 0.2);
        } else if (availableSeats > capacity*0.25 && availableSeats <= capacity*0.5) {
            price = fare + (fare * 0.35);
        } else {
            price = fare + (fare * 0.50);
        }

        return price;
    }

    public double _byDays() {
        double price = 0;
        int totalNumberOfDays;
        double priceByAvailableSeats=_byAvailableSeats();
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(departureDate, currentDate);
        int numberOfDays = period.getDays();
        if(numberOfDays<0)
        {
            totalNumberOfDays = (int) Math.copySign(numberOfDays,-1);
        }
        else {
            totalNumberOfDays=numberOfDays;
        }
        System.out.println(totalNumberOfDays);
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

    public double getTotalClassFare() {
        return _byDays();
    }
}