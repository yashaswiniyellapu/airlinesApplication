package com.everest.airline.model;

public class SecondClassTest implements FlightClassTest{
    private int availableSeats;
    private int passengerCount;
    private String methodType;

    public SecondClassTest(int availableSeats, int passengerCount) {
        this.availableSeats = availableSeats;
        this.passengerCount = passengerCount;
    }

    @Override
    public double fareCalculation() {
        return passengerCount*availableSeats;
    }

    @Override
    public double getClassFare() {
        return 200;
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
