package com.everest.airline.services;

public class ValidateData {
    public boolean checkFlightData(int passengerCount, String classType, int economicSeats, int firstClassSeats, int secondClassSeats) {
        boolean checkData;

        switch (classType) {
            case "economic":
                checkData = isValid(economicSeats, passengerCount);
                break;
            case "first":
                checkData = isValid(firstClassSeats, passengerCount);

                break;
            case "second":
                checkData = isValid(secondClassSeats, passengerCount);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + classType);
        }
        return checkData;
    }
        public boolean isValid ( int availableSeats, int passengerCount)
        {
            if (passengerCount <= availableSeats) {
                return true;
            }
            return false;
        }

    }

