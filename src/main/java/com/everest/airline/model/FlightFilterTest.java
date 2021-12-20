package com.everest.airline.model;

import com.everest.airline.enums.FareType;

public class FlightFilterTest {
    private String classType;
    private FlightClassTest flightClassTest;

    public FlightFilterTest(String classType) {
        this.classType = classType;
    }
    public Object filterFlight(int passengerCount,int economicSeats,int secondClassSeats,int firstClassSeats,String methodType)
    {
        Object result;
        switch (classType) {
            case "economic":
            {
                flightClassTest = new EconomicTest(passengerCount);
                flightClassTest.setMethodType(methodType);
                result=flightClassTest.getMethod();
            }


            break;
            default:
                throw new IllegalStateException("Unexpected value: " + classType);
        }
        return result;
    }
}
