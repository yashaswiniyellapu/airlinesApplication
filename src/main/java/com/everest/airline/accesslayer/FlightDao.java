package com.everest.airline.accesslayer;

import com.everest.airline.database.FlightRowMapper;
import com.everest.airline.datasource.DataSourceConfig;
import com.everest.airline.model.Flight;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.Date;
import java.util.List;

public class FlightDao implements Dao<Flight> {
    @Override
    public List<Flight> getAll(String source, String destination, String departureDate) {

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("source",source)
                .addValue("destination",destination)
                .addValue("departure_date", Date.valueOf(departureDate));
        String sql = "select * from flights_data where source=:source and destination=:destination"+
                " and departure_date=:departure_date";
        return new DataSourceConfig().JdbcTemplate().query(sql,params,new FlightRowMapper());
    }

    @Override
    public void update(Flight flight) {

    }

}
