package it.opendelivey.demo.controllers;

import it.opendelivey.demo.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile(
            Model model,
            HttpSession session
    ){

        //TODO: controllare se i parametri sono corretti

        Utente utente = Utente.utenteSample();
        model.addAttribute(utente);

        return "profile";
    }
}
