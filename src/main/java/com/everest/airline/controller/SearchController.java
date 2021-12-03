package com.everest.airline.controller;

import com.everest.airline.services.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SearchController {

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search")
    public String search(String from, String to, String date, Model model) {
        model.addAttribute("flights", new SearchService(from, to, date).flight());
        return "search";
    }
}
