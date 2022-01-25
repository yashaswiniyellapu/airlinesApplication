package com.everest.airline.controller;


import com.everest.airline.database.FlightRowMapper;
import com.everest.airline.database.LastIndex;
import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
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

    // Create
    @PostMapping ("/flights")
    public long create(@RequestBody Flight flight) {
       List<Long> lastIdValue = jdbcTemplate.query("select max(flight_id) from flights_data ;", new LastIndex());
       SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
               .addValue("flight_id", lastIdValue.get(0) +1)
               .addValue("source",flight.getSource())
               .addValue("destination",flight.getDestination())
               .addValue("departure_date", flight.getDepartureDate())
               .addValue("departure_time",flight.getDepartureTime())
               .addValue("arrival_time", flight.getArrivalTime())
               .addValue("economic_capacity",flight.getEconomicClass().getCapacity())
               .addValue("economic_seats_available",flight.getEconomicClass().getSeatsLeft())
               .addValue("firstClass_capacity",flight.getFirstClass().getCapacity())
               .addValue("firstClass_seats_available",flight.getFirstClass().getSeatsLeft())
               .addValue("secondClass_capacity",flight.getSecondClass().getCapacity())
               .addValue("secondClass_seats_available",flight.getSecondClass().getSeatsLeft());
       String sqlQuery = "insert into flights_data values (:flight_id,:source,:destination,:departure_date," +
               ":departure_time,:arrival_time,:economic_capacity,:economic_seats_available,:firstClass_capacity," +
               ":firstClass_seats_available,:secondClass_capacity,:secondClass_seats_available); ";
       jdbcTemplate.update(sqlQuery,sqlParameterSource);
        return lastIdValue.get(0);
    }
//
    // Update
    @PutMapping("/flights/{number}")
    public Flight update(@PathVariable Long number, @RequestBody Flight flight) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("flight_id", number)
                .addValue("source",flight.getSource())
                .addValue("destination",flight.getDestination())
                .addValue("departure_date", flight.getDepartureDate())
                .addValue("departure_time",flight.getDepartureTime())
                .addValue("arrival_time", flight.getArrivalTime())
                .addValue("economic_capacity",flight.getEconomicClass().getCapacity())
                .addValue("economic_seats_available",flight.getEconomicClass().getSeatsLeft())
                .addValue("firstClass_capacity",flight.getFirstClass().getCapacity())
                .addValue("firstClass_seats_available",flight.getFirstClass().getSeatsLeft())
                .addValue("secondClass_capacity",flight.getSecondClass().getCapacity())
                .addValue("secondClass_seats_available",flight.getSecondClass().getSeatsLeft());
        String sqlQuery = "update flights_data set source=:source, destination=:destination, " +
                "departure_time=:departure_time, arrival_time =:arrival_time, economic_capacity=:economic_capacity," +
                "economic_seats_available=:economic_seats_available,firstClass_capacity=:firstClass_capacity," +
        "firstClass_seats_available=:firstClass_seats_available,secondClass_capacity=:secondClass_capacity," +
        "secondClass_seats_available=:secondClass_seats_available where flight_id=:flight_id;";
        jdbcTemplate.update(sqlQuery,sqlParameterSource);
        return flight;
    }

    // Delete
    @DeleteMapping("/flights/{number}")
    public String delete(@PathVariable long number) {
       SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
               .addValue("flight_id",number);
       jdbcTemplate.update("delete from flights_data where flight_id=:flight_id;",sqlParameterSource);
        return "deleted";
    }
}

