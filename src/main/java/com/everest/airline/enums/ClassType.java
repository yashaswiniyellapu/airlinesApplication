package com.everest.airline.enums;

public enum ClassType {
    economic(170), first(200), second(350);

    private double fare;

    ClassType(double fare) {
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

}
