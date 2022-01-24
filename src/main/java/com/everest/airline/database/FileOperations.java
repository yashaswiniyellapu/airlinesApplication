//package com.everest.airline.database;
//
//import com.everest.airline.comparator.FlightComparator;
//import com.everest.airline.model.Flight;
//import com.everest.airline.views.EconomicClass;
//import com.everest.airline.views.FirstClass;
//import com.everest.airline.views.SecondClass;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class FileOperations {
//
//    private static final List<Long> deletedId = new ArrayList();
//
//    public static void allFlights() {
////        List<Flight> flights = DataReader.multipleFilesData().stream().map(fileName -> fileName.getValue()).map(data ->{
////                Flight flight = new Flight();
////        flight.setNumber(Long.parseLong(data[0]));flight.setSource(data[1]);flight.setDestination(data[2]);
////        flight.setDepartureDate( Date.parse(data[3]));flight.setDepartureTime(LocalTime.parse(data[4]));
////        flight.setArrivalTime(Time.parse(data[5]));
////        Flight.setEconomicClass(new EconomicClass(Integer.parseInt(data[10]),Integer.parseInt(data[7])));
////        Flight.setSecondClass(new SecondClass(Integer.parseInt(data[11]),Integer.parseInt(data[8])));
////        Flight.setFirstClass(new FirstClass(Integer.parseInt(data[12]),Integer.parseInt(data[9])));return flight;})
////                .collect(Collectors.toList());
////        return flights.stream().sorted((f1, f2) -> new FlightComparator().compare(f1, f2)).collect(Collectors.toList());
//    }
//
//
//    public static Flight singleFlight(String flightNumber) {
//        String[] fileData = DataReader.singleFileData(flightNumber);
//        Flight flight = new Flight();
//        flight.setNumber(Long.parseLong(fileData[0]));flight.setSource(fileData[1]);flight.setDestination(fileData[2]);
//        flight.setDepartureDate( LocalDate.parse(fileData[3]));flight.setDepartureTime(LocalTime.parse(fileData[4]));
//        flight.setArrivalTime(LocalTime.parse(fileData[5]));
//        Flight.setEconomicClass(new EconomicClass(Integer.parseInt(fileData[10]),Integer.parseInt(fileData[7])));
//        Flight.setSecondClass(new SecondClass(Integer.parseInt(fileData[11]),Integer.parseInt(fileData[8])));
//        Flight.setFirstClass(new FirstClass(Integer.parseInt(fileData[12]),Integer.parseInt(fileData[9])));
//        return flight;
//    }
//
//
//    public static void create(Long flightNumber, Flight flight) {
//
//        try (BufferedWriter bw = new BufferedWriter(
//                new FileWriter("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/" +
//                        "airline/database/flightsData/" + flightNumber + ".txt")))
//        {
//            bw.write(flightNumber + "," + flight.getSource() + "," + flight.getDestination() +
//                    "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + ","
//                    + flight.getArrivalTime() + "," + flight.getAvailableSeats() + ","
//                    + flight.getEconomicClass().getSeatsLeft() + "," + flight.getSecondClass().getSeatsLeft() + ","
//                    + flight.getFirstClass().getSeatsLeft() + "," + flight.getEconomicClass().getCapacity() + ","
//                    + flight.getSecondClass().getCapacity() + "," + flight.getFirstClass().getCapacity());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void update(Long flightNumber, Flight flight) {
//
//        allFlights().stream().filter(f -> f.getNumber() == flightNumber).forEach(f ->
//        {
//            try (BufferedWriter bw =
//                         new BufferedWriter
//                                 (new FileWriter("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/" +
//                                         "everest/airline/database/flightsData/" + flightNumber + ".txt"))) {
//                bw.write(flight.getNumber() + "," + flight.getSource() + "," + flight.getDestination()
//                        + "," + flight.getDepartureDate() + "," + flight.getDepartureTime() + ","
//                        + flight.getArrivalTime() + "," + flight.getAvailableSeats() + ","
//                        + flight.getEconomicClass().getSeatsLeft() + "," + flight.getSecondClass().getSeatsLeft() + ","
//                        + flight.getFirstClass().getSeatsLeft() + "," + flight.getEconomicClass().getCapacity() + ","
//                        + flight.getSecondClass().getCapacity() + "," + flight.getFirstClass().getCapacity());}
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//    public static boolean delete(Long flightNumber) {
//        deletedId.add(flightNumber);
//        File file = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/" +
//                "database/flightsData/" + flightNumber + ".txt");
//        return file.delete();
//    }
//}
