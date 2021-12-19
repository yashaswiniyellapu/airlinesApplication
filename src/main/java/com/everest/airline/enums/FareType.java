package com.everest.airline.enums;

public enum FareType {
    ECONOMIC(170), FIRST(200), SECOND(350);

    private double fare;

    FareType(double fare) {
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

}
