package com.everest.airline.database;

import com.everest.airline.model.Flight;
import com.everest.airline.views.FlightClassType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightRowMapper implements RowMapper<Flight> {
    @Override
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        Flight flight = new Flight();
        flight.setNumber(rs.getLong("flight_id"));
        flight.setSource(rs.getString("source"));
        flight.setDestination(rs.getString("destination"));
        flight.setDepartureDate(rs.getDate("departure_date"));
        flight.setDepartureTime(rs.getTime("departure_time"));
        flight.setArrivalTime(rs.getTime("arrival_time"));
        FlightClassType ec = new FlightClassType();
        ec.setCapacity(rs.getInt("economicClass_capacity"));
        ec.setAvailableSeats(rs.getInt("economicClass_seats_available"));
        FlightClassType sc = new FlightClassType();
        sc.setCapacity(rs.getInt("secondClass_capacity"));
        sc.setAvailableSeats(rs.getInt("secondClass_seats_available"));
        FlightClassType fc = new FlightClassType();
        fc.setCapacity(rs.getInt("firstClass_capacity"));
        fc.setAvailableSeats(rs.getInt("firstClass_seats_available"));
        flight.setEconomicClass(ec);
        flight.setFirstClass(fc);
        flight.setSecondClass(sc);
        return flight;
    }
}
