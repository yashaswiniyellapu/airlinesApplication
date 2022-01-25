
package com.everest.airline.views;


public class FlightClassType  {
    private int capacity;
    private  int availableSeats;
    private double classFare;
    private double totalFare;
    public FlightClassType(){}

    public double getClassFare() {
        return classFare;
    }

    public int getSeatsLeft() {
        return availableSeats;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setClassFare(double fare) {
        this.classFare = fare;

    }

    public void setTotalFare(double fare) {
        totalFare = fare;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
