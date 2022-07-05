package it.opendelivey.demo.controllers;


import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.Indirizzo;
import it.opendelivey.demo.model.RegistrationForm;
import it.opendelivey.demo.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.AttributeNotFoundException;

@Controller
public class RegistrationController {
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
        Utente u= new Utente();
        u.setNome(form.getNome());
        u.setCognome(form.getCognome());
        u.setMail(form.getMail());
        //u.setIndirizzo(indirizzo);
        u.setPassword(form.getPassword());
        u.setEta(50);


        repoUtente.save(u);
        return "login";
    }
}
