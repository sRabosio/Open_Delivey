package it.opendelivey.demo.controllers;


import it.opendelivey.demo.model.Indirizzo;
import it.opendelivey.demo.model.RegistrationForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RegistrationController {

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
            @RequestParam("nome") String nome,
            @RequestParam("cognome") String cognome,
            @RequestParam("email") String email,
            @RequestParam("via") String via,
            @RequestParam("cap") int cap,
            @RequestParam("civico") String civico,
            @RequestParam("password") String password,
            @RequestParam("conferma_password") String passwordConf
    ) {
        //controllo conferma password
        if (!password.equals(passwordConf)) return "registrazione";

        Indirizzo indirizzo = new Indirizzo(
                via, cap, civico, null
        );

        RegistrationForm form = new RegistrationForm(
                nome, cognome, email, password, indirizzo
        );

        //TODO: email confirmation
        //TODO: piantare i dati nel DB

        //se la richiesta è andata a buon fine manderò
        //l'utente alla pagina di login per loggarsi
        System.out.println(form);
        return "login";
    }
}
