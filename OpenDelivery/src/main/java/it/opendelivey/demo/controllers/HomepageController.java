package it.opendelivey.demo.controllers;

import it.opendelivey.demo.handlers.HomepageHandler;
import it.opendelivey.demo.model.LoginForm;
import it.opendelivey.demo.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomepageController {

    /*TODO: verificare che i dati siano corretti per evitare che
     *  i dati possano essere visti da qualcuno senza autorizzazione */
    @GetMapping("/homepage")
    public String getHomepage(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare (da fare nell'apposita classe, ovvero: non qua)
        Utente utente = Utente.utenteSample();
        LoginForm userLogin;
        //per ora usa delle informazioni codificate nella classe per testarne il funzionamento
        //successivamente qua andranno i dati dal db
        userLogin = new LoginForm(email, password);
        System.out.println(userLogin);
        System.out.println(utente);

        //usare equals per comparare gli oggetti non mi funziona
        //se qualcuno sa come farlo lo faccia, sta roba è cancerogena
        if (!(userLogin.getMail().equals(utente.getMail())
                && userLogin.getPassword().equals(utente.getPassword()))
        ) return "login";

        model.addAttribute(utente);

        return "homepage";
    }
}
