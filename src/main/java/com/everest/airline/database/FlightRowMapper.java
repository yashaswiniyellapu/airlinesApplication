package com.everest.airline.database;

import com.everest.airline.model.Flight;
import com.everest.airline.views.EconomicClass;
import com.everest.airline.views.FirstClass;
import com.everest.airline.views.SecondClass;
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
        EconomicClass ec = new EconomicClass(rs.getInt("economic_capacity"),
                rs.getInt("economic_seats_available"));
        SecondClass sc = new SecondClass(rs.getInt("secondClass_capacity"),
                rs.getInt("secondClass_seats_available"));
        FirstClass fc = new FirstClass(rs.getInt("firstClass_capacity"),
                rs.getInt("firstClass_seats_available"));
        flight.setEconomicClass(ec);
        flight.setFirstClass(fc);
        flight.setSecondClass(sc);
        return flight;
    }

//    public Long lastIndex(ResultSet rs, int rowNum) throws SQLException
//    {
//
//    }
}
