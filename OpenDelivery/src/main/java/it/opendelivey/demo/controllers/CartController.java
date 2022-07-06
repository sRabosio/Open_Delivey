package it.opendelivey.demo.controllers;

import it.opendelivey.demo.model.Piatto;
import it.opendelivey.demo.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @GetMapping("/cart")
    public String getCart(
            Model model,
            HttpSession session
    ){
        //TODO: aggiungi utente dal database

        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(utente == null) return "login";

        Piatto[] carrello = new Piatto[]{
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
        };
        model.addAttribute("utente", utente);
        model.addAttribute("carrello", carrello);
        model.addAttribute("items", 0);

        return "cart";
    }

    @PostMapping("/cart")
    public String deleteFromChart(
            @RequestParam("idPiatto") int idPiatto,
            @RequestParam("mail") String mail,
            @RequestParam("password") String password
    ){
        //TODO: delete from user chart

        return "cart";
    }
}
