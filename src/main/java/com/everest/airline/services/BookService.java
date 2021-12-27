package com.everest.airline.services;

import com.everest.airline.database.DataRetriever;
import com.everest.airline.views.FlightClassFilter;
import com.everest.airline.model.Flight;
import com.everest.airline.views.FlightClassType;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class BookService {
    FlightClassFilter filter;
    FlightClassType test;

    public void updateData(Long flightNumber, String classType, String passengerCount, List<Flight> flightData) throws IOException {
        for(Flight flight:flightData)
        {
            String line;
            String updatedLine;
            File directory = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData");
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    DataRetriever data = new DataRetriever(file);
                    if(file.getName().equalsIgnoreCase(flightNumber + ".txt"))
                    {
                        line = data.readFile();
                        filter= new FlightClassFilter(classType);
                        test= filter.filterClass(flight);
                            updatedLine = test.getUpdatedData(flightNumber,Integer.parseInt(passengerCount));
                            if(updatedLine!=null)
                            {
                                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                                line = line.replace(line, updatedLine);
                                writer.write(line);
                                writer.close();
                                break;
                            }
                        }
                    }

                }
            }
        }


}

