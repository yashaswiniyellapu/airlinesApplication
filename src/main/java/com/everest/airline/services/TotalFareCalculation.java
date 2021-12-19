package com.everest.airline.services;

import com.everest.airline.enums.FareType;
import org.springframework.stereotype.Component;

@Component
public class TotalFareCalculation {
    public double totalFare(int passengerCount, String classType)
    {
        double fare;
        switch (classType) {
            case "economic":
               fare= FareType.ECONOMIC.getFare()*passengerCount;
               break;
            case "first":
                fare= FareType.FIRST.getFare()*passengerCount;
                break;
                case "second":
                fare= FareType.SECOND.getFare()*passengerCount;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + classType);
        }
        return fare;
    }
}
