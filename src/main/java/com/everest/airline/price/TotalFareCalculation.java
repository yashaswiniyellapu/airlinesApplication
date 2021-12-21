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
        double price = 0;
        double result1 = capacity * 0.3;
        double result2 = capacity * 0.5;
        double result3 = capacity * 0.75;
        if (availableSeats <= (int) result1) {
            price = fare;
        } else if (availableSeats > (int) result1 && availableSeats <= (int) result2) {
            price = fare + (fare * 0.2);
        } else if (availableSeats > (int) result2 && availableSeats <= (int) result3) {
            price = fare + (fare * 0.35);
        } else if (availableSeats > (int) result3 && availableSeats <= capacity) {
            price = fare + (fare * 0.50);
        }

        return price;
    }

    public double _byDays() {
        double price = 0;
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(departureDate, currentDate);
        int numberOfDays = period.getDays();
        if (numberOfDays < 0) {
            numberOfDays *= (-1);
        }
        int TotalNumberOfDays = numberOfDays;
        if (TotalNumberOfDays > 0 && TotalNumberOfDays <= 3) {
            int day = 3 - TotalNumberOfDays + 1;
            price = fare + (fare * day * 0.02);
        } else if (TotalNumberOfDays > 3 && TotalNumberOfDays <= 10) {
            int day = 10 - TotalNumberOfDays + 1;
            price = fare + (fare * day * 0.02);
        } else if (TotalNumberOfDays > 10) {
            price = fare;
        }
        return price;
    }

    public double addTotalFare() {
        return _byDays() + _byAvailableSeats();
    }
}