package it.opendelivey.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllore {
    @GetMapping("/index")
    public String Index() {
        return "registrazione";
    }
    @PostMapping("/login")
    public String Login() {
        return "registrazione";
    }
    @PostMapping("/registrazione")
    public String Registrazione() {
        return "registrazione";
    }
    @PostMapping("/carello")
    public String Carrello() {
        return "registrazione";
    }
    @PostMapping("/account")
    public String Account () {
        return "registrazione";
    }
    @GetMapping("/ricerca")
    public String Ricarca () {
        return "registrazione";
    }
    @PostMapping("/salvati")
    public String Salvati () {
        return "registrazione";
    }
    @GetMapping("/ristorante")
    public String Ristorante () {
        return "registrazione";
    }
   /* @GetMapping("/homepage")
    public String Homepage() {
        return "registrazione";
    }*/
}
