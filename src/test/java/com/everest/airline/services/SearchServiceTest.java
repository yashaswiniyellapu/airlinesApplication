package com.everest.airline.services;

import com.everest.airline.database.DataReader;
import com.everest.airline.model.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchServiceTest {
    @Autowired
    SearchService search;
    Set<Map.Entry<String, String[]>> list = DataReader.multipleFilesData();

    SearchServiceTest() throws IOException {
    }

    @Test
    void sortByUserData()  {

      boolean isPresent= list.parallelStream().map(Map.Entry::getValue).anyMatch(fileData-> fileData[1].equalsIgnoreCase("Hyderabad")
       &&fileData[2].equalsIgnoreCase("Bangalore")&& fileData[3].equalsIgnoreCase("2021-12-30"));
        Assertions.assertTrue(isPresent);


    }
}