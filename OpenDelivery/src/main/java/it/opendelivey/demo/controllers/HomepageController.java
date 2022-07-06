package it.opendelivey.demo.controllers;

import it.opendelivey.demo.model.Piatto;
import it.opendelivey.demo.model.Ristorante;
import it.opendelivey.demo.model.Utente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomepageController {

    /*TODO: verificare che i dati siano corretti per evitare che
     *  i dati possano essere visti da qualcuno senza autorizzazione */
    @RequestMapping("/homepage")
    public String getHomepage(
            Model model,
            HttpSession session
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare (da fare nell'apposita classe, ovvero: non qua)

        Utente utente = (Utente)session.getAttribute("loggedUser");

        System.out.println(utente);

        Piatto[] consigliati = {
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample()
        };

        Ristorante[] ristoranti = {
                Ristorante.ristoranteSample(),
                Ristorante.ristoranteSample(),
                Ristorante.ristoranteSample(),
                Ristorante.ristoranteSample(),
        };

        //usare equals per comparare gli oggetti non mi funziona
        //se qualcuno sa come farlo lo faccia, sta roba è cancerogena


        model.addAttribute("utente", utente);
        model.addAttribute("consigliati", consigliati);
        model.addAttribute("ristoranti", ristoranti);

        return "homepage";
    }
}
