package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.RepoAllergie;
import it.opendelivey.demo.Repo.RepoIndirizzoUtente;
import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.Allergie;
import it.opendelivey.demo.model.IndirizzoUtente;
import it.opendelivey.demo.model.LoginForm;
import it.opendelivey.demo.model.Utente;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@Controller
public class ProfileController {

    @Autowired
    RepoUtente repoUtenteDao;

    @Autowired
    RepoIndirizzoUtente repoIndirizzoUtenteDao;

    @Autowired
    RepoAllergie repoAllergieDao;

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
            HttpSession session
    ){
        if(session.getAttribute("loggedUser") == null) return "redirect:/login";
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(
                Utente.validate(utente, repoUtenteDao)
        )) return "redirect:/login";



        return "changepassword";
    }

    @PostMapping("/profile/changepassword")
    public String changepasswordaction(
            LoginForm loginForm,
            @RequestParam("password_new") String newPassword,
            @RequestParam("password_new_conf") String newPasswordConf,
            HttpSession session,
            Model model
    ){
        if(session.getAttribute("loggedUser") == null) return "redirect:/login";

        //controllo che i dati vecchi del profilo siano giusti
        if(
                !(repoUtenteDao.existsByMailAndPassword(loginForm.getMail(), loginForm.getPassword()))
        ) return "redirect:/login";


        //controllo che le due password coincidano e che la nuova password non sia uguale a quella vecchia
        if(!(newPassword.equals(newPasswordConf))){
            model.addAttribute("title", "ERRORE");
            model.addAttribute("message", "la nuova password deve essere uguale a quella di conferma");
            return "changepassword";
        }
        if(newPassword.equals(loginForm.getPassword())){
            model.addAttribute("title", "ERRORE");
            model.addAttribute("message", "la nuova password non può essere uguale a quella vecchia");
            return "changepassword";
        }

        //salvo la nuova password e faccio riloggare l'utente
        Utente utente = repoUtenteDao.findByMail(loginForm.getMail());
        utente.setPassword(newPassword);
        repoUtenteDao.save(utente);
        session.setAttribute("loggedUser", null);
        return "redirect:/login";
    }

    @GetMapping("/profile/allergie")
    public String allergieprofilo(
            Model model,
            HttpSession session
    ){
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";
        Set<Allergie> allergieUtente = utente.getAllergie();
        ArrayList<Allergie> allAllergie = repoAllergieDao.findAll();


        for(Allergie allergia: allergieUtente){
            allAllergie.remove(allergia);
        }

        model.addAttribute("utente", utente);
        model.addAttribute("allergieprofilo", allergieUtente);
        model.addAttribute("allergie", allAllergie);

        return "allergieprofilo";
    }

    @PostMapping("/profile/allergie/add")
    public String allergieprofiloAdd(
            HttpSession session,
            @RequestParam("allergiaId") Integer[] allergieIds
    ){
            Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        ArrayList<Allergie> allergie = repoAllergieDao.findAllById(Arrays.asList(allergieIds));
        if(allergie == null || allergie.size() < 1) return "redirect:/profile/allergie";

        for(Allergie allergia: allergie){
            if(utente.getAllergie().contains(allergia))
                continue;
            utente.addAllergie(allergia);
        }

        repoUtenteDao.save(utente);
        session.setAttribute("loggedUser", utente);
        return "redirect:/profile/allergie";
    }
}
