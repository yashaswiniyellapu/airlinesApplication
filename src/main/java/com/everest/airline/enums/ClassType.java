package com.everest.airline.enums;

public enum ClassType {
    ECONOMIC(170), FIRST(200), SECOND(350);

    private double fare;

    ClassType(double fare) {
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

}
