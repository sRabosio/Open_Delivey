package it.opendelivey.demo.controllers;


import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.RegistrationForm;
import it.opendelivey.demo.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    RepoUtente repoUtente;

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
            RegistrationForm form
    ) {

        int i = 0;
        //controllo conferma password




        //TODO: email confirmation
        //TODO: piantare i dati nel DB

        //se la richiesta è andata a buon fine manderò
        //l'utente alla pagina di login per loggarsi
        System.out.println(form);
        Utente U= new Utente();
        U.setNome(form.getNome());
        U.setCognome(form.getCognome());
        U.setMail(form.getMail());
        //U.setIndirizzo(indirizzo);
        U.setPassword(form.getPassword());
        U.setEta(50);


        repoUtente.save(U);
        return "login";
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
        //session ci permette di "mantenere" delle informazioni
        //che vengono prese da delle richieste
        //per venir utilizzate in altre
        session.setAttribute("loggedUser", Utente.utenteSample());
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

