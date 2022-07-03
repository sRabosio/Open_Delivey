package it.opendelivey.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChartController {

    @GetMapping("/chart")
    public String getChart(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ){


        return "chart";
    }
}
