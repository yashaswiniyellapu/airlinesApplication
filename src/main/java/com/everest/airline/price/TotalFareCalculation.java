package com.everest.airline.price;

import com.everest.airline.enums.FareType;

public class TotalFareCalculation {
    //    public double totalFare(int passengerCount, String classType)
//    {
//        double fare;
//        switch (classType) {
//            case "economic":
//               fare= FareType.ECONOMIC.getFare()*passengerCount;
//               break;
//            case "first":
//                fare= FareType.FIRST.getFare()*passengerCount;
//                break;
//                case "second":
//                fare= FareType.SECOND.getFare()*passengerCount;
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + classType);
//        }
//        return fare;
//    }
    private int economicCapacity;
    private int firstClassCapacity;
    private int secondClassCapacity;
    private int economicSeats;
    private int secondClassSeats;
    private int firstClassSeats;
    private int capacity;
    private double basePrice = 0;

    private int availableSeats;

    public TotalFareCalculation(int economicCapacity, int secondClassCapacity, int firstClassCapacity, int economicSeats, int secondClassSeats, int firstClassSeats) {
        this.economicCapacity = economicCapacity;
        this.firstClassCapacity = firstClassCapacity;
        this.secondClassCapacity = secondClassCapacity;
        this.economicSeats = economicSeats;
        this.secondClassSeats = secondClassSeats;
        this.firstClassSeats = firstClassSeats;
    }

    public double calculateFare() {
        double price = 0;
        double result1 = capacity * 0.3;
        double result2 = capacity * 0.5;
        double result3 = capacity * 0.75;
        if (availableSeats <= (int) result1) {
            price = basePrice;
        } else if (availableSeats > (int) result1 && availableSeats <= (int) result2) {
            price = basePrice + (basePrice * 0.2);
        } else if (availableSeats > (int) result2 && availableSeats <= (int) result3) {
            price = basePrice + (basePrice * 0.35);
        } else if (availableSeats > (int) result3 && availableSeats <= economicCapacity) {
            price = basePrice + (basePrice * 0.50);
        }

        return price;
    }

    public double getTotalFare(String classType) {
        switch (classType) {
            case "economic":
                capacity = economicCapacity;
                availableSeats = economicSeats;
                basePrice = FareType.ECONOMIC.getFare();

                break;
            case "first":
                capacity = firstClassCapacity;
                availableSeats = firstClassSeats;
                basePrice = FareType.FIRST.getFare();
                break;
            case "second":
                capacity = secondClassCapacity;
                availableSeats = secondClassSeats;
                basePrice = FareType.SECOND.getFare();
                break;

        }
        return calculateFare();
    }
}
