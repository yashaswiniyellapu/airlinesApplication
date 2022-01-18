package com.everest.airline.controller;

import com.everest.airline.model.Flight;
//import com.everest.airline.services.BookService;
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
    //public BookService updateBooking;

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, String date, String passengersCount, String classType, Model model) {

        try {
            flightData = searchService.flightObjectTest(from, to, date, passengersCount, classType);
            searchService.showFlightObject(flightData.get(0));
            System.out.println(flightData);
            if (flightData.size() == 0) {
                return "error";
            }
        } catch (IllegalStateException e) {
            return "flightsUnavailable";
        } catch (Exception e) {
            e.printStackTrace();
        }
        flightData.stream().map();
        model.addAttribute("flights", flightData);
        model.addAttribute("classType", classType);
        model.addAttribute("classFare", searchService.getFare());
        model.addAttribute("passengerCount", passengersCount);
        model.addAttribute("totalFare", searchService.getTotalFare());


        return "search";
    }

    @RequestMapping(value = "/book/{number}/{classType}/{passengerCount}")
    public String book(@PathVariable("number") Long number, @PathVariable("classType") String classType, @PathVariable("passengerCount") String passengerCount) {
//        try {
//            updateBooking.updateData(number, classType, passengerCount, flightData);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "book";

    }
}
