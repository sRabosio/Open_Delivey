package it.opendelivey.demo.controllers;

import it.opendelivey.demo.model.LoginForm;
import it.opendelivey.demo.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

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
        session.setAttribute("loggedUser", Utente.utenteSample());
        return "redirect:homepage";
    }



}
