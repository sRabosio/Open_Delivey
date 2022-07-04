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
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ){

        //TODO: controllare se i parametri sono corretti

        Utente utente = Utente.utenteSample();
        model.addAttribute(utente);

        return "profile";
    }
}
