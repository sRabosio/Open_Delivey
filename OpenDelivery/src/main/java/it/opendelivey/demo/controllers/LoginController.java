package it.opendelivey.demo.controllers;

import it.opendelivey.demo.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        LoginForm dbLogin, userLogin;
        //per ora usa delle informazioni codificate nella classe per testarne il funzionamento
        //successivamente qua andranno i dati dal db
        dbLogin = LoginForm.testForm();
        userLogin = new LoginForm(email, password);
        System.out.println(userLogin);

        //usare equals per comparare gli oggetti non mi funziona
        //se qualcuno sa come farlo lo faccia, sta roba è cancerogena
        if (!(userLogin.getMail().equals(dbLogin.getMail())
                && userLogin.getPassword().equals(dbLogin.getPassword()))
        ) return "login";

        //TODO: fare in modo di passare l'id dell'utente all'homepage
        return "homepage";
    }
}
