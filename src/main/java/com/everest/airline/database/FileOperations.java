package com.everest.airline.database;

import com.everest.airline.comparator.FlightComparator;
import com.everest.airline.model.Flight;
import com.everest.airline.views.EconomicClass;
import com.everest.airline.views.FirstClass;
import com.everest.airline.views.SecondClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileOperations {

    private static final List<Long> deletedId = new ArrayList();

    public static List<Flight> allFlights() {
        List<Flight> flights = DataReader.multipleFilesData().stream().map(fileName -> fileName.getValue()).map(data ->
                        new Flight(Long.parseLong(data[0]), data[1], data[2], LocalDate.parse(data[3]), LocalTime.parse(data[4]),
                                LocalTime.parse(data[5]),
                                new EconomicClass(Integer.parseInt(data[10]), Integer.parseInt(data[7])),
                                new SecondClass(Integer.parseInt(data[11]), Integer.parseInt(data[8])),
                                new FirstClass(Integer.parseInt(data[12]), Integer.parseInt(data[9]))))
                .collect(Collectors.toList());
        return flights.stream().sorted((f1, f2) -> new FlightComparator().compare(f1, f2)).collect(Collectors.toList());
    }


    public static Flight singleFlight(String flightNumber) {
        String[] fileData = DataReader.singleFileData(flightNumber);
        return new Flight(Long.parseLong(fileData[0]), fileData[1], fileData[2],
                LocalDate.parse(fileData[3]),
                LocalTime.parse(fileData[4]), LocalTime.parse(fileData[5]),
                new EconomicClass(Integer.parseInt(fileData[10]), Integer.parseInt(fileData[7])),
                new SecondClass(Integer.parseInt(fileData[11]), Integer.parseInt(fileData[8])),
                new FirstClass(Integer.parseInt(fileData[12]), Integer.parseInt(fileData[9])));
    }


    public static void create(Long flightNumber, Flight flight) {

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/" +
                        "airline/database/flightsData/" + flightNumber + ".txt")))
        {
            bw.write(flightNumber + "," + flight.getSource() + "," + flight.getDestination() +
                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + ","
                    + flight.getArrivalTime() + "," + flight.getAvailableSeats() + ","
                    + flight.getEconomicClass().getSeatsLeft() + "," + flight.getSecondClass().getSeatsLeft() + ","
                    + flight.getFirstClass().getSeatsLeft() + "," + flight.getEconomicClass().getCapacity() + ","
                    + flight.getSecondClass().getCapacity() + "," + flight.getFirstClass().getCapacity());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void update(Long flightNumber, Flight flight) {

        allFlights().stream().filter(f -> f.getNumber() == flightNumber).forEach(f ->
        {
            try (BufferedWriter bw =
                         new BufferedWriter
                                 (new FileWriter("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/" +
                                         "everest/airline/database/flightsData/" + flightNumber + ".txt"))) {
                bw.write(flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination()
                        + "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + ","
                        + flight.getArrivalTime() + "," + flight.getAvailableSeats() + ","
                        + flight.getEconomicClass().getSeatsLeft() + "," + flight.getSecondClass().getSeatsLeft() + ","
                        + flight.getFirstClass().getSeatsLeft() + "," + flight.getEconomicClass().getCapacity() + ","
                        + flight.getSecondClass().getCapacity() + "," + flight.getFirstClass().getCapacity());}
            catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static boolean delete(Long flightNumber) {
        deletedId.add(flightNumber);
        File file = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/" +
                "database/flightsData/" + flightNumber + ".txt");
        return file.delete();
    }
}
