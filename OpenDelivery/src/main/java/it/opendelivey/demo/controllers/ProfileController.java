package it.opendelivey.demo.controllers;

import it.opendelivey.demo.handlers.ProfileHandler;
import it.opendelivey.demo.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(
            @RequestParam("id") int id,
            @RequestParam("password") String password,
            Model model
    ){
        Utente utente = Utente.utenteSample();
        model.addAttribute(utente);

        return "profile";
    }
}
