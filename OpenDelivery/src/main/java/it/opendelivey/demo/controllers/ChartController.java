package it.opendelivey.demo.controllers;

import it.opendelivey.demo.model.Piatto;
import it.opendelivey.demo.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChartController {

    @GetMapping("/chart")
    public String getChart(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ){
        //TODO: aggiungi utente dal database

        Utente utente = Utente.utenteSample();
        //Piatto[] carrello = utente.getCarrello();

        model.addAttribute("utente", utente);
        //model.addAttribute("carrello", carrello);
        model.addAttribute("items", 0);

        return "chart";
    }

    @PostMapping("/chart")
    public String deleteFromChart(
            @RequestParam("idPiatto") int idPiatto,
            @RequestParam("mail") String mail,
            @RequestParam("password") String password
    ){
        //TODO: delete from user chart

        return "chart";
    }
}
