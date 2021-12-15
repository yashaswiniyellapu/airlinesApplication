package com.everest.airline.controller;

import com.everest.airline.model.Flight;
import com.everest.airline.services.BookTicketService;
import com.everest.airline.services.Cabin;
import com.everest.airline.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@Controller
public class SearchController {


    private String from;
    private String to;
    private String departureDate;

    private List<Flight> flightData;
    @Autowired
    public SearchService searchService;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, String date, Model model) throws IOException {
        if (from != null) {
            this.departureDate = date;
            this.to = to;
            this.from = from;
        }
        flightData = searchService.flight(this.from, this.to, this.departureDate);
        if (flightData.size() == 0) {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                return "error";
            }

        } else {
            model.addAttribute("flights", flightData);
            return "search";
        }
    }

    @RequestMapping(value = "/book/{number}")
    public String book(@PathVariable("number") Long number, String classType, String numberOfPassengers) throws IOException {
        Cabin type = new Cabin(classType, numberOfPassengers);
        String line = type.seatsLeft(flightData);
        BookTicketService bookFlight = new BookTicketService(number);
        bookFlight.seatsLeft(Path.of
                ("/Users/yashaswiniyellapu/Documents/airlines/src/main/java/com/everest/airline/database/flightsData"), line);
        System.out.println("class type " + classType);
        return "redirect:/search";
    }
}
