package com.everest.airline.controller;

import com.everest.airline.exceptions.FlightNotFoundException;
import com.everest.airline.model.Flight;
import com.everest.airline.services.BookService;
//import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {


    private List<Flight> flightData;
//    @Autowired
//    public SearchService searchService;
    @Autowired
    public BookService book;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, String date, int passengersCount, String classType, Model model) {
       // flightData = searchService.flightObjectTest(from, to, date, passengersCount, classType);
        if (flightData.isEmpty()) {
            throw new FlightNotFoundException();
        }
        model.addAttribute("flights", flightData);
        model.addAttribute("classType", classType);
        model.addAttribute("passengerCount", passengersCount);
        model.addAttribute("classFare", passengersCount);
        return "search";
    }

    @RequestMapping(value = "/book/{number}/{classType}/{passengerCount}")
    public String book(@PathVariable("number") Long number, @PathVariable("classType") String classType, @PathVariable("passengerCount") String passengerCount) {
        book.updateData(number, classType, Integer.parseInt(passengerCount), flightData);
        return "book";

    }
}
