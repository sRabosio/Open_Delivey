package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.RepoRistorante;
import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantController {

    @GetMapping("/ristorante")
    public String getRestaurant(
            @RequestParam("id") int id,
            Model model
    ){
        model.addAttribute("risorante",Ristorante.ristoranteSample());
        return "restaurant";
    }

}
