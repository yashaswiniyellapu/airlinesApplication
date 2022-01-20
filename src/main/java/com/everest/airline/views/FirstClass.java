
package com.everest.airline.views;

public class FirstClass implements FlightClassType {
    private int capacity;
    private int availableSeats;
    private double classFare;
    private double totalFare;

    public FirstClass(int capacity, int availableSeats) {

        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }

    @Override
    public double getClassFare() {
        return classFare;
    }

    @Override
    public int getSeatsLeft() {
        return availableSeats;
    }


    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public double getTotalFare() {
        return totalFare;
    }

    @Override
    public void setClassFare(double fare) {
        this.classFare = fare;

    }

    @Override
    public void setTotalFare(double fare) {
        this.totalFare = fare;

    }


}
