package com.everest.airline.services;

import com.everest.airline.database.DirectoryReader;
import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Component
public class BookService {

    public void updateData(Long flightNumber, String classType, int passengerCount, List<Flight> flightData) {
        flightData.parallelStream().forEach(flight -> DirectoryReader.ListOfFiles()
                .stream()
                .filter(file -> file.getValue().contains(Long.toString(flightNumber)))
                .forEach(file -> {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getValue()))) {
                        bw.write(flight.toString(passengerCount, classType));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }));
    }
}

