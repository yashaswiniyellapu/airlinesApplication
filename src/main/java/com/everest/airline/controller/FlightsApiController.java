//package com.everest.airline.controller;
//
//import com.everest.airline.database.FileOperations;
//import com.everest.airline.model.Flight;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@RestController
//    public class FlightsApiController {
//        private List<Flight> flights= FileOperations.getFlights();
//        @GetMapping("/flights")
//        public List<Flight> getAllFlights(@PathVariable Optional<String> number) {
//            System.out.println("number" + number);
//            List<Flight> specificFlight;
//            if(number.isPresent())
//            {
//                specificFlight= flights.stream().filter(f-> number.toString().equalsIgnoreCase(Long.toString(f.getNumber()))).collect(Collectors.toList());
//                return specificFlight;
//            }
//          return flights;
//        }
////    @GetMapping("/flights/{number}")
////    public List<Flight> getFlights(@PathVariable Optional<String> number) {
////        System.out.println("number" + number);
////        return flights;
////    }
//
//        // CUD
//        @PostMapping("/flights")
//        public long create(String source, String destination, String departureDate, String departureTime, String arrivalTime, String availableSeats, String economicSeats, String secondClassSeats, String firstClassSeats, String economicCapacity, String secondClassCapacity, String firstClassCapacity) {
//            long lastId = flights.get(flights.size() -1).getNumber();
//            long newId = lastId+1;
//            Flight flight = new Flight(newId, source,destination, LocalDate.parse(departureDate), LocalTime.parse(departureTime), LocalTime.parse(arrivalTime),Integer.parseInt(availableSeats), Integer.parseInt(economicSeats), Integer.parseInt(secondClassSeats), Integer.parseInt(firstClassSeats) ,Integer.parseInt(economicCapacity),  Integer.parseInt(secondClassCapacity), Integer.parseInt(firstClassCapacity));
//            flights.add(flight);
//            FileOperations.createFile(newId,flights.get(flights.size()-1));
//            return flight.getNumber();
//        }
//
//        // Update
//        @PutMapping("/flights/{number}")
//        public Flight update(@PathVariable long number,String source, String destination, String departureDate, String departureTime, String arrivalTime, String availableSeats, String economicSeats, String secondClassSeats, String firstClassSeats, String economicCapacity, String secondClassCapacity, String firstClassCapacity) {
//
//
//            // Get the file
//            // Update the file
//            // Response updated data
//           Flight flight = new Flight(number, source,destination, LocalDate.parse(departureDate), LocalTime.parse(departureTime), LocalTime.parse(arrivalTime),Integer.parseInt(availableSeats), Integer.parseInt(economicSeats), Integer.parseInt(secondClassSeats), Integer.parseInt(firstClassSeats) ,Integer.parseInt(economicCapacity),  Integer.parseInt(secondClassCapacity), Integer.parseInt(firstClassCapacity));
//            //Data.flights.set(Data.flights.indexOf(existingFlight), flight);
//            FileOperations.updateData(number,flight);
//            return flight;
//        }
//
//        // Update
//        @DeleteMapping("/flights/{number}")
//        public void delete(@PathVariable long number) {
//            // Delete the file
//            FileOperations.deleteFile(number);
//        }
//    }
//
