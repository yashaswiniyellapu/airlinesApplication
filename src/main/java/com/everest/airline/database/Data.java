package com.everest.airline.database;

import com.everest.airline.model.Flight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
    private static List<Flight> flights;

    public static List<Flight> getData() {
        try {
            FileInputStream file = new FileInputStream("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData.txt");
            List<String> input = new BufferedReader(new InputStreamReader(file)).lines().collect(Collectors.toList());
            List<String[]> data = input.stream().map(e -> e.split(",")).collect(Collectors.toList());
            flights = new ArrayList<>();
            for (String[] datum : data) {
                flights.add(new Flight(Long.parseLong(datum[0]), datum[1], datum[2], LocalDate.parse(datum[3]), LocalTime.parse(datum[4]), LocalTime.parse(datum[5]), Integer.parseInt(datum[6])));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flights;
    }


}


