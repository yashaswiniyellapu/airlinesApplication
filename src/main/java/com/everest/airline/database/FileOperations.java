package com.everest.airline.database;

import com.everest.airline.model.Flight;
import com.everest.airline.views.EconomicClass;
import com.everest.airline.views.FirstClass;
import com.everest.airline.views.SecondClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileOperations {
    private static final List<Long> deletedId=new ArrayList();
    public static Map<Long, Flight> getFlights() {
return DataReader.multipleFilesData().stream().map(fileName-> fileName.getValue()).map(data->
           new Flight(Long.parseLong(data[0]),data[1],data[2],LocalDate.parse(data[3]),LocalTime.parse(data[4]),
                   LocalTime.parse(data[5]),
                     new EconomicClass(Integer.parseInt(data[10]),Integer.parseInt(data[7])),
                     new SecondClass(Integer.parseInt(data[11]),Integer.parseInt(data[8])),
                     new FirstClass(Integer.parseInt(data[12]),Integer.parseInt(data[9]))))
         .collect(Collectors.toMap(flight->flight.getNumber(),flight->flight));

    }

    public static void createFile(Long flightNumber, Flight flight) {

        try {
            FileWriter writer = new FileWriter("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData/" + flightNumber + ".txt");
            writer.write(flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                    flight.getArrivalTime() + "," + flight.getAvailableSeats() +
                    "," + flight.getEconomicClass().getSeatsLeft() + "," + flight.getSecondClass().getSeatsLeft() + "," + flight.getFirstClass().getSeatsLeft() + "," +
                    flight.getEconomicClass().getCapacity() + "," + flight.getSecondClass().getCapacity() + "," + flight.getFirstClass().getCapacity());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateData(Long flightNumber, Flight flight) {
        try {
            FileWriter writer = new FileWriter("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData/" + flightNumber + ".txt");
            writer.write(flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + "," +
                    flight.getArrivalTime() + "," + flight.getAvailableSeats() +
                    "," + flight.getEconomicClass().getSeatsLeft() + "," + flight.getSecondClass().getSeatsLeft() + "," + flight.getFirstClass().getSeatsLeft() + "," +
                    flight.getEconomicClass().getCapacity() + "," + flight.getSecondClass().getCapacity() + "," + flight.getFirstClass().getCapacity());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFile(Long flightNumber)
    {
        deletedId.add(flightNumber);
        File file = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData/" + flightNumber + ".txt");
         file.delete();
    }
}
