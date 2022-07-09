package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.RepoPiatto;
import it.opendelivey.demo.Repo.RepoRistorante;
import it.opendelivey.demo.Repo.RepoTipo;
import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.Piatto;
import it.opendelivey.demo.model.Ristorante;
import it.opendelivey.demo.model.Tipo;
import it.opendelivey.demo.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class HomepageController {

    @Autowired
    private RepoUtente repoUtenteDao;

    @Autowired
    private RepoRistorante repoRistoranteDao;

    @Autowired
    private RepoPiatto repoPiattoDao;

    @Autowired
    private RepoTipo repoTipoDao;

    /*TODO: verificare che i dati siano corretti per evitare che
     *  i dati possano essere visti da qualcuno senza autorizzazione */
    @RequestMapping("/homepage")
    public String getHomepage(
            Model model,
            HttpSession session
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare (da fare nell'apposita classe, ovvero: non qua)

        Utente utente = (Utente)session.getAttribute("loggedUser");
        if(utente == null) return "login";

        System.out.println(utente);

        ArrayList<Piatto> consigliati = repoPiattoDao.findAll();

        ArrayList<Ristorante> ristoranti = repoRistoranteDao.findAll();

        ArrayList<Tipo> categorie = repoTipoDao.findAll();

        //usare equals per comparare gli oggetti non mi funziona
        //se qualcuno sa come farlo lo faccia, sta roba è cancerogena


        model.addAttribute("utente", utente);
        model.addAttribute("consigliati", consigliati);
        model.addAttribute("ristoranti", ristoranti);
        model.addAttribute("categorie", categorie);

        return "homepage";
    }
}
