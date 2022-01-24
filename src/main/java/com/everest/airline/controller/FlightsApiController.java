package com.everest.airline.controller;


import com.everest.airline.database.FlightRowMapper;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightsApiController {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
//get flights
    @GetMapping({"/flights", "/flights/{number}"})
    public List<Flight> getAllFlights(@PathVariable Optional<Long> number) {
        if (number.isPresent()) {
            SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                    .addValue("number", number.get());
            return jdbcTemplate.query("SELECT * from flights_data where flight_id = :number ;", sqlParameterSource, new FlightRowMapper());
        }
        return jdbcTemplate.query("SELECT * from flights_data ;", new FlightRowMapper());
    }


//
//    // Create
//    @PostMapping("/flights")
//    public long create(@RequestBody Flight flight) {
//        System.out.println("flight " + flight);
//        Long oldId = FileOperations.allFlights().get(FileOperations.allFlights().size() - 1).getNumber();
//        long newId = oldId + 1;
//        FileOperations.create(newId, flight);
//        return newId;
//    }
//
//    // Update
//    @PutMapping("/flights/{number}")
//    public Flight update(@PathVariable Long number, @RequestBody Flight flight) {
//        FileOperations.update(number, flight);
//        return flight;
//    }
//
//    // Delete
//    @DeleteMapping("/flights/{number}")
//    public String delete(@PathVariable long number) {
//        // Delete the file
//        FileOperations.delete(number);
//        return "deleted";
//    }
}

