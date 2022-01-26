package com.everest.airline.accesslayer;

import java.util.List;

public interface Dao<Flight> {
    List<Flight> getAll(String source, String destination, String date);
    void update(Long id, String classType, int passengerCount);
}
