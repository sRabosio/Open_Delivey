package it.opendelivey.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllore {
    @GetMapping("/index")
    public String Index() {
        return "registrazione";
    }
    @RequestMapping("/login")
    public String Login() {
        return "login";
    }
    @RequestMapping("/registrazione")
    public String Registrazione() {
        return "registrazione";
    }
    @RequestMapping("/carello")
    public String Carrello() {
        return "registrazione";
    }
    @RequestMapping("/account")
    public String Account () {
        return "registrazione";
    }
    @RequestMapping("/ricerca")
    public String Ricarca () {
        return "registrazione";
    }
    @RequestMapping("/salvati")
    public String Salvati () {
        return "registrazione";
    }
    @RequestMapping("/ristorante")
    public String Ristorante () {
        return "registrazione";
    }
    @RequestMapping("/home")
    public String Homepage() {
        return "homepage";
    }
}
