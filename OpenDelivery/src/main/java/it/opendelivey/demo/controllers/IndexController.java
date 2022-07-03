package it.opendelivey.demo.controllers;


import it.opendelivey.demo.model.Indirizzo;
import it.opendelivey.demo.model.LoginForm;
import it.opendelivey.demo.model.RegistrationForm;
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
}

