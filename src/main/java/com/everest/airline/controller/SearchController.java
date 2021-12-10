package com.everest.airline.controller;

import com.everest.airline.model.Flight;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String search(String from, String to, String date, Model model) {
        model.addAttribute("flights", searchService.flight(from, to, date));
        List<Flight> returnedFlightData = searchService.flight(from, to, date);
        searchService.leftOverSeats(returnedFlightData);
        return "search";
    }
}
