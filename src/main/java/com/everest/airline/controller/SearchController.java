package com.everest.airline.controller;

import com.everest.airline.database.DataReader;

import com.everest.airline.model.Flight;
import com.everest.airline.services.BookService;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class SearchController {


    private List<Flight> flightData;
    @Autowired
    public SearchService searchService;
    @Autowired
    public BookService updateBooking;

    @RequestMapping(value = "/")
    public String home() {
        System.out.println(DataReader.getFilesData());


        return "home";
    }
    @RequestMapping(value = "/search")
    public String search(String from, String to, String date, String passengersCount, String classType, Model model) {
        System.out.println( searchService.testFlightObject(from, to, date,passengersCount,classType));


        try {
            flightData = searchService.flight(from, to, date, passengersCount, classType);
            if (flightData.size() == 0) {
                return "error";
            }
        } catch (IllegalStateException e) {
            return "flightsUnavailable";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("flights", flightData);
        model.addAttribute("classType", classType);
        model.addAttribute("classFare", searchService.getFare());
        model.addAttribute("passengerCount", passengersCount);
        model.addAttribute("totalFare", searchService.getTotalFare());


        return "search";
    }

    @RequestMapping(value = "/book/{number}/{classType}/{passengerCount}")
    public String book(@PathVariable("number") Long number, @PathVariable("classType") String classType, @PathVariable("passengerCount") String passengerCount) {
        try {
            updateBooking.updateData(number, classType, passengerCount, flightData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "book";

    }
}
