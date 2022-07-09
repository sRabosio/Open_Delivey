package it.opendelivey.demo.controllers;


import it.opendelivey.demo.Repo.RepoAllergie;
import it.opendelivey.demo.Repo.RepoIndirizzoUtente;
import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.RegistrationForm;
import it.opendelivey.demo.model.Utente;
import it.opendelivey.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class IndexController {

    @Autowired
    RepoUtente repoUtente;
    @Autowired
    RepoAllergie repoAllergie;
    @Autowired
    RepoIndirizzoUtente repoIndirizzoUtenteDao;

    /* mappare tutte le richieste con metodo vuoto ci permette di entrare nella pagina
     * con qualsiasi richiesta, o, SEMPLICEMENTE se non metto questo entrerà nella pagina
     * solo quando uso la richiesta specificata con gli attributi specificati */
    @RequestMapping("/registrazione")
    public String Registrazione() {
        return "registrazione";
    }

    //processo di registrazione
    @PostMapping("/registrazione")
    public String Registrazione(
            RegistrationForm form,
            IndirizzoUtente indirizzo,
            HttpSession session
    ) {

        int i = 0;
        //controllo conferma password




        //TODO: email confirmation
        //TODO: piantare i dati nel DB

        //se la richiesta è andata a buon fine manderò
        //l'utente alla pagina di login per loggarsi
        System.out.println(form);
        Utente u= new Utente();
        u.setNome(form.getNome());
        u.setCognome(form.getCognome());
        u.setMail(form.getMail());
        //U.setIndirizzo(indirizzo);
        u.setPassword(form.getPassword());
        u.setEta(form.getEta());
        if(repoUtente.findByMail(form.getMail()) != null)
            return "registrazione";

        repoUtente.save(u);
        indirizzo.setUtente(u);
        repoIndirizzoUtenteDao.save(indirizzo);
        session.setAttribute("loggedUser",u);
        return "redirect:/allergie-iscrizione";
    }

    @GetMapping("/allergie-iscrizione")
    public String allergie_iscrizione(HttpSession session, Model model) {
        ArrayList<Allergie> allergie;
        allergie = repoAllergie.findAll();
        model.addAttribute("allergie",allergie);
        return "allergie-iscrizione";
    }
    @PostMapping("/allergie-iscrizione")
    public String allergie_iscrizione( HttpSession session, ArrayList <Allergie> allergie){
       Utente utente= (Utente) session.getAttribute("loggedUser");
       if (utente==null)return "login";
        repoUtente.save(utente);
       return "homepage";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(

            @RequestParam("mail") String mail,
            @RequestParam("password") String password,
            HttpSession session

    ){
        Utente dbutente;
        if(( dbutente= (Utente) repoUtente.findByMail(mail)) == null || !(dbutente.getPassword().equals(password))) return "login";
        //session ci permette di "mantenere" delle informazioni
        //che vengono prese da delle richieste
        //per venir utilizzate in altre
        session.setAttribute("loggedUser", dbutente);
        //usiamo redirect per "portarci" alla richiesta "/homepage"
        //invece di andare sulla pagina HTML
        return "redirect:homepage";
    }


    @RequestMapping("/")
    public String index(HttpSession session) {
        Utente utente = (Utente)session.getAttribute("loggedUser");
        if(utente == null) return "registrazione";
        return "redirect:homepage";
    }

}

