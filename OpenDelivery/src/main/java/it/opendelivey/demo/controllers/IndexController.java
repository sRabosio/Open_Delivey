package it.opendelivey.demo.controllers;


import it.opendelivey.demo.model.Indirizzo;
import it.opendelivey.demo.model.LoginForm;
import it.opendelivey.demo.model.RegistrationForm;
import it.opendelivey.demo.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    //NB: i metodi non hanno la maiuscola iniziale

    @RequestMapping("/")
    public String index() {

        //TODO: controllare se i dati di login sono salvati nel browser e agire di conseguenza
        return "registrazione";
    }

    @PostMapping("/")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ){

        Utente utente = Utente.utenteSample();
        LoginForm userLogin;
        //per ora usa delle informazioni codificate nella classe per testarne il funzionamento
        //successivamente qua andranno i dati dal db
        userLogin = new LoginForm(email, password);
        System.out.println(userLogin);
        System.out.println(utente);

        if (!(userLogin.getMail().equals(utente.getMail())
                && userLogin.getPassword().equals(utente.getPassword()))
        ) return "login";

        return "forward:/homepage";
    }
}

