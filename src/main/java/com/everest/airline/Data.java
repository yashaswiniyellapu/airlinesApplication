package com.everest.airline;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Data {
    static List<Flight> flights = List.of(

            new Flight(1001, "Hyderabad", "Bangalore", LocalDate.of(2021,12,05), LocalTime.of(10,30),LocalTime.of(12,0), 7),
            new Flight(1002, "Bangalore", "Hyderabad",LocalDate.of(2021,12,06),LocalTime.of(10,30),LocalTime.of(12,0),7),
            new Flight(1003, "Goa", "Bangalore",LocalDate.of(2021,12,05),LocalTime.of(10,30),LocalTime.of(12,0),7),
            new Flight(1004, "Bangalore", "Goa",LocalDate.of(2021,12,06),LocalTime.of(10,30),LocalTime.of(12,0), 7),
            new Flight(1005, "Bangalore", "Hyderabad",LocalDate.of(2021,12,07),LocalTime.of(10,30),LocalTime.of(12,0), 7),
            new Flight(1006, "Hyderabad", "Bangalore",LocalDate.of(2021,12,06),LocalTime.of(10,30),LocalTime.of(12,0), 7));}


