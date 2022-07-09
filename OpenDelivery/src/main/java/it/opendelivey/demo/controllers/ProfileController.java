package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.RepoIndirizzoUtente;
import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.IndirizzoUtente;
import it.opendelivey.demo.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Set;

@Controller
public class ProfileController {

    @Autowired
    RepoUtente repoUtenteDao;

    @Autowired
    RepoIndirizzoUtente repoIndirizzoUtenteDao;

    @GetMapping("/profile")
    public String profile(
            Model model,
            HttpSession session
    ){
        //prendo l'utente
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(
                Utente.validate(utente, repoUtenteDao)
                )) return "redirect:/login";

        //prendo i suoi indirizzi
        ArrayList<IndirizzoUtente> indirizzi = repoIndirizzoUtenteDao.findByUtente(utente);

        model.addAttribute(utente);
        model.addAttribute("indirizzi", indirizzi);

        return "profile";
    }

    @GetMapping("/profile/changepassword")
    public String changepassword(
            Model model,
            HttpSession session
    ){
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(
                Utente.validate(utente, repoUtenteDao)
        )) return "redirect:/login";

        return "changepassword";
    }
}
