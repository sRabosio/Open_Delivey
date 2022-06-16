package it.opendelivey.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controllore {
    @RequestMapping("/")
    public String Index() {
        return "registrazione";
    }

    @RequestMapping("/login")
    public String Login() {
        return "registrazione";
    }

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
    ){

        return "registrazione";
    }


    /*@PostMapping("/carello")
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
    @GetMapping("/homepage")
    public String Homepage() {
        return "registrazione";
    }*/
}
