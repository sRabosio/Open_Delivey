package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.RepoPiatto;
import it.opendelivey.demo.Repo.RepoRistorante;
import it.opendelivey.demo.model.Piatto;
import it.opendelivey.demo.model.Ristorante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;
import java.util.Set;

@Controller
public class RestaurantController {

    @Autowired
    RepoRistorante repoRistoranteDao;

    @Autowired
    RepoPiatto repoPiattoDao;

    @GetMapping("/ristorante")
    public String getRestaurant(
            @RequestParam("id") int id,
            Model model
    ){
        Optional<Ristorante> ristorante = repoRistoranteDao.findById(id);
        if(ristorante.isEmpty()) return "redirect:/homepage";
        Set<Piatto> menu = ristorante.get().getProdotti();

        model.addAttribute("ristorante",ristorante.get());
        model.addAttribute("menu", menu);
        return "restaurant";
    }

    @GetMapping("/piatto")
    public String getPiatto(
            @RequestParam("id") int id,
            Model model
    ){

        return "plate";
    }

}
