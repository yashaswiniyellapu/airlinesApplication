package com.everest.airline.model;

public class EconomicTest implements FlightClassTest{
    private int passengerCount;
    private Object methodType;
    EconomicTest(int passengerCount)
    {
        this. passengerCount = passengerCount;
    }
    @Override
    public double fareCalculation() {
        return passengerCount*getClassFare();
    }

    @Override
    public double getClassFare() {
        return 175;
    }

    @Override
    public String getUpdatedData(Flight flight) {
        int seatsLeft = flight.getEconomicClassSeats()-passengerCount;
        int availableSeats=flight.getAvailableSeats()-passengerCount;
        return flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                flight.getArrivalTime() + "," + availableSeats +
                "," + seatsLeft + "," + flight.getSecondClassSeats() + "," + flight.getFirstClassSeats()+","+
                flight.getEconomicCapacity()+","+ flight.getSecondClassCapacity()+","+flight.getFirstClassCapacity();
    }

    @Override
    public void setMethodType(String methodType) {
        switch (methodType) {
            case "fareCalculation":
                this.methodType = fareCalculation();
                break;
            case "classFare":
                this.methodType = getClassFare();
                break;
            case "writeFile":
                this.methodType=getUpdatedData()

        }


    }

    @Override
    public Object getMethod() {
       return methodType;
    }
}
