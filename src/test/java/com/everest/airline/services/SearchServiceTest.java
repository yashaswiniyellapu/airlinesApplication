package com.everest.airline.services;

import com.everest.airline.database.Data;
import com.everest.airline.model.Flight;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchServiceTest {
    List<Flight> list = Data.getFlights();

    @Test
    void sortByPlace() {

        SearchService search = new SearchService("Hyderabad", "Bangalore", "2021-12-05");
        List<Flight> result = search.flight();
        assertEquals(List.of(list.get(0)), result);


    }
}