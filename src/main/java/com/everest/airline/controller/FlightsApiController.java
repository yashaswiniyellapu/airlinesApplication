package com.everest.airline.controller;

import com.everest.airline.database.FileOperations;
import com.everest.airline.model.Flight;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightsApiController {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("/flights")
    public List<Flight> getAllFlights(@PathVariable Optional<String> number) {
        return FileOperations.allFlights();

    }

    //single flight
    @GetMapping("/flights/{number}")
    public Flight getFlights(@PathVariable String number) {
        System.out.println("number" + number);
        return FileOperations.singleFlight(number);
    }

    // Create
    @PostMapping("/flights")
    public long create(@RequestBody Flight flight) {
        System.out.println("flight " + flight);
        Long oldId = FileOperations.allFlights().get(FileOperations.allFlights().size() - 1).getNumber();
        long newId = oldId + 1;
        FileOperations.create(newId, flight);
        return newId;
    }

    // Update
    @PutMapping("/flights/{number}")
    public Flight update(@PathVariable Long number, @RequestBody Flight flight) {
        FileOperations.update(number, flight);
        return flight;
    }

    // Delete
    @DeleteMapping("/flights/{number}")
    public String delete(@PathVariable long number) {
        // Delete the file
        FileOperations.delete(number);
        return "deleted";
    }
}

