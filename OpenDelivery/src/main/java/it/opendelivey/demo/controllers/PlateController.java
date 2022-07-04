package it.opendelivey.demo.controllers;

import it.opendelivey.demo.model.Piatto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlateController {

    @GetMapping("/piatto")
    public String getPiatto(
            @RequestParam("id") int id,
            Model model
    ){

        model.addAttribute(Piatto.piattoSample());

        return "plate";
    }

}
