package com.everest.airline.model;

public class FirstClassTest implements FlightClassTest {
    private int availableSeats;
    private int passengerCount;
    private String methodType;

    public FirstClassTest(int passengerCount, int availableSeats) {
        this.availableSeats = availableSeats;
        this.passengerCount = passengerCount;
    }

    @Override
    public double fareCalculation() {
        return passengerCount * availableSeats;
    }

    @Override
    public double getClassFare() {
        return 350;
    }

    @Override
    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    @Override
    public String getMethod() {
        return null;
    }
}
