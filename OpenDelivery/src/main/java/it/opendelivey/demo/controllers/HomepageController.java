package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.RepoRistorante;
import it.opendelivey.demo.Repo.RepoTipo;
import it.opendelivey.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomepageController {

    @Autowired
    private RepoRistorante repoRistoranteDao;

    @Autowired
    private RepoTipo repoTipoDao;


    @RequestMapping("/homepage")
    public String getHomepage(
            Model model,
            HttpSession session
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare (da fare nell'apposita classe, ovvero: non qua)

        ArrayList<Tipo> filter = (ArrayList<Tipo>) session.getAttribute("filter");
        Utente utente = (Utente)session.getAttribute("loggedUser");
        if(utente == null) return "login";
        //uso filter ids per thymeleaf, sempre per il casino degli equals
        ArrayList<Integer> filtersId = new ArrayList<>();

        System.out.println(utente);




        ArrayList<Ristorante> ristoranti = repoRistoranteDao.findAll();

        ArrayList<Tipo> categorie = repoTipoDao.findAll();

        //rimuovo ristoranti e piatti secondo i filtri impostati

        //L'equals sull'oggetto tipo non funziona
        //dio solo sa il motivo
        //la soluzione fa schifo, ma funziona (miracolo)
        if(filter != null)
            for(Tipo i: filter) {
                ristoranti.removeIf(r -> !(r.hasTipo(i)));
                filtersId.add(i.getId());
            }



            //prendo i piatti dai ristoranti che ho filtrato
        ArrayList<Piatto> consigliati = new ArrayList<>();
        for(Ristorante r: ristoranti){
            List<Piatto> piattoList = r.getProdotti().stream().toList();
            consigliati.addAll(piattoList);
        }

        if(utente.getAllergie() != null)
            for(Allergie a:utente.getAllergie())
                consigliati.removeIf(c->c.hasAllergia(a));

        model.addAttribute("utente", utente);
        model.addAttribute("consigliati", consigliati);
        model.addAttribute("ristoranti", ristoranti);
        model.addAttribute("categorie", categorie);
        model.addAttribute("filtri", filtersId);

        return "homepage";
    }

    @GetMapping("/homepage/addFilter")
    public String homepageCat(
            HttpSession session,
            @RequestParam("idCategoria") Integer idCat
    ){
        ArrayList<Tipo> filter = (ArrayList<Tipo>) session.getAttribute("filter");
        if(filter == null)
           filter = new ArrayList<>();

        Optional<Tipo> tipo = repoTipoDao.findById(idCat);

        if(tipo.isPresent() &&
                !(filter.removeIf(
                        t->t.getId().equals(tipo.get().getId())
                        )))
            filter.add(tipo.get());


        session.setAttribute("filter", filter);

        return "redirect:/homepage";
    }

    @GetMapping("/homepage/altriristoranti")
    public String moreRestaurants(
            Model model
    ){
        ArrayList<Ristorante> ristoranti = repoRistoranteDao.findAll();
        model.addAttribute("ristoranti", ristoranti);
        return "moreRestaurants";
    }

}
