package it.opendelivey.demo.controllers;

import it.opendelivey.demo.handlers.HomepageHandler;
import it.opendelivey.demo.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomepageController {

    /*TODO: verificare che i dati siano corretti per evitare che
     *  i dati possano essere visti da qualcuno senza autorizzazione */
    @RequestMapping("/homepage")
    public String getHomepage(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare (da fare nell'apposita classe, ovvero: non qua)

        Utente utente = Utente.utenteSample();

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

        Tipo[] categories = {
                Tipo.tipoSample(),
                Tipo.tipoSample(),
                Tipo.tipoSample(),
                Tipo.tipoSample(),
                Tipo.tipoSample(),
                Tipo.tipoSample()
        };

        //usare equals per comparare gli oggetti non mi funziona
        //se qualcuno sa come farlo lo faccia, sta roba è cancerogena


        model.addAttribute("utente", utente);
        model.addAttribute("consigliati", consigliati);
        model.addAttribute("ristoranti", ristoranti);
        model.addAttribute("categories", categories);

        return "homepage";
    }
}
