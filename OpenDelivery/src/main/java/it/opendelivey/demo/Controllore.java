package it.opendelivey.demo;


import it.opendelivey.demo.dataStructures.Indirizzo;
import it.opendelivey.demo.dataStructures.LoginForm;
import it.opendelivey.demo.dataStructures.RegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controllore {

    //NB: i metodi non hanno la maiuscola iniziale

    @RequestMapping("/")
    public String index() {

        //TODO: controllare se i dati di login sono salvati nel browser e agire di conseguenza
        return "registrazione";
    }

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
