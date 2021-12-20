package com.everest.airline.controller;

import com.everest.airline.model.Flight;
import com.everest.airline.model.FlightClassTest;
import com.everest.airline.model.FlightFilterTest;
import com.everest.airline.price.Test;
import com.everest.airline.services.DataUpdater;
import com.everest.airline.services.SearchService;
import com.everest.airline.services.TotalFareCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {


    private List<Flight> flightData;
    @Autowired
    public SearchService searchService;
    @Autowired
    public TotalFareCalculation totalFareCalculation;
    @Autowired
    public DataUpdater dataUpdater;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, String date, String passengersCount, String classType, Model model) throws Exception {

            try {
                flightData = searchService.flight(from, to, date, passengersCount, classType);
            }
        catch (IllegalStateException e)
        {
            return "flightsUnavailable";
        }
        model.addAttribute("flights", flightData);
        model.addAttribute("classType", classType);
        model.addAttribute("classFare", classType);
        model.addAttribute("passengerCount", passengersCount);
        model.addAttribute("totalFare", searchService.getPrice());


        return "search";
    }

    @RequestMapping(value = "/book/{number}/{classType}/{passengerCount}")
    public String book(@PathVariable("number") Long number, @PathVariable("classType") String classType, @PathVariable("passengerCount") String passengerCount, Model model) throws Exception {
        try {
            dataUpdater.updateData(number, classType, passengerCount, flightData);
            model.addAttribute("flights", flightData);
            return "book";
        } catch (Exception e) {
            return "flightsUnavailable";
        }

    }
}
