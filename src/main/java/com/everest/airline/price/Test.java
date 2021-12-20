package com.everest.airline.price;

public class Test {

    private int economicCapacity;
   private  int firstClassSeats;
   private int secondClassSeats;

    public Test(int economicCapacity, int secondClassSeats, int firstClassSeats) {
        this.economicCapacity = economicCapacity;
        this.firstClassSeats = firstClassSeats;
        this.secondClassSeats = secondClassSeats;

    }

    public double basePrice(int availableSeats)
    {

        double basePrice=170;
        double price = 0;
        double result1 = economicCapacity*0.3;
        double result2 = economicCapacity*0.5;
        double result3 = economicCapacity*0.75;
        if(availableSeats<=(int)result1)
        {
            price = basePrice;
        }
        else if(availableSeats>(int)result1 && availableSeats<=(int)result2)
        {
            price = basePrice+ (basePrice*0.2);
        }
        else if(availableSeats>(int)result2 && availableSeats<=(int)result3)
        {
            price = basePrice+ (basePrice*0.35);
        }
        else if(availableSeats>(int)result3 && availableSeats<=economicCapacity)
        {
            price = basePrice+ (basePrice*0.50);
        }

        return price;
    }
}
