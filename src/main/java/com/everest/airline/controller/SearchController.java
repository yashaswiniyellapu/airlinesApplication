package com.everest.airline.controller;

import com.everest.airline.model.Flight;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    public SearchService searchService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, String date, String numberOfPassengers, Model model) throws IOException {
        try {
            List<Flight> flightData = searchService.flight(from, to, date);
            if (flightData.size() == 0) {
                throw new NullPointerException();
            } else {
                model.addAttribute("flights", searchService.flight(from, to, date));
                List<Flight> returnedFlightData = searchService.flight(from, to, date);
                searchService.seatsLeft(returnedFlightData);
                System.out.println("number of passengers " + numberOfPassengers);
                return "search";
            }
        } catch (NullPointerException e) {
            return "error";

        }
    }
}
