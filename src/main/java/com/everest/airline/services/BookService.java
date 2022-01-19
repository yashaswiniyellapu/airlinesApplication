package com.everest.airline.services;

import com.everest.airline.database.DataReader;
import com.everest.airline.database.DirectoryReader;
import com.everest.airline.model.Flight;
import com.everest.airline.validator.FlightClasses;
import com.everest.airline.views.FlightClassType;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class BookService {

    public void updateData(Long flightNumber, String classType, int passengerCount, List<Flight> flightData) throws IOException {
//        for(Flight flight:flightData)
//        {
//            String line;
//            String updatedLine;
//            File directory = new File("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData");
//            File[] listOfFiles = directory.listFiles();
//            if (listOfFiles != null) {
//                for (File file : listOfFiles) {
//                    DataReader data = new DataReader(file);
//                    if(file.getName().equalsIgnoreCase(flightNumber + ".txt"))
//                    {
//                        line = data.readFile();
//                        filter= new FlightClassFilter(classType);
//                        test= filter.filterClass(flight);
//                            updatedLine = test.getUpdatedData(flightNumber,Integer.parseInt(passengerCount));
//                            if(updatedLine!=null)
//                            {
//                                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//                                line = line.replace(line, updatedLine);
//                                writer.write(line);
//                                writer.close();
//                                break;
//                            }
//                        }
//                    }
//
//                }
//            }
        flightData.parallelStream().forEach(flight -> DirectoryReader.getListOfFiles().stream().
                filter(file -> file.getValue().contains(Long.toString(flightNumber))).
                forEach(file -> {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getValue()))) {
                        bw.write(flight.toString(passengerCount, classType));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }));
    }
    //1001,Hyderabad,Bangalore,2021-12-30,10:20,12:44,95,56,25,14,60,15,25

}

