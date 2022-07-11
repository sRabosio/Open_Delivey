package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.*;
import it.opendelivey.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class RestaurantController {

    @Autowired
    private RepoRistorante repoRistoranteDao;

    @Autowired
    private RepoPiatto repoPiattoDao;

    @Autowired
    private RepoUtente repoUtenteDao;

    @Autowired
    private RepoOrdine repoOrdineDao;

    @Autowired
    private RepoRecordOrdine repoOrdineRecordDao;

    @GetMapping("/ristorante")
    public String getRestaurant(
            @RequestParam("id") int id,
            Model model
    ){
        Optional<Ristorante> ristorante = repoRistoranteDao.findById(id);
        if(ristorante.isEmpty()) return "redirect:/homepage";
        ArrayList<Piatto> menu = repoPiattoDao.findByRistoranti(ristorante.get());

        model.addAttribute("ristorante",ristorante.get());
        model.addAttribute("menu", menu);
        return "restaurant";
    }

    @GetMapping("/piatto")
    public String getPiatto(
            @RequestParam("id") int id,
            Model model
    ){

        Optional<Piatto> prodotto = repoPiattoDao.findById(id);
        if(prodotto.isEmpty()) return "redirect:/homepage";

        model.addAttribute("prodotto", prodotto.get());
        model.addAttribute("allergeni", prodotto.get().getAllergeni());

        return "plate";
    }

    @PostMapping("/piatto/add")
    public String addPiatto(
            @RequestParam("id") Integer id,
            @RequestParam("q") int quantita,
            HttpSession session
    ){
        if(quantita < 1) return "redirect:/piatto";

        Ordine carrello = null;

        //prendo utente
        Utente utente = (Utente)session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        //prendo il piatto da inserire
        Optional<Piatto> prodotto = repoPiattoDao.findById(id);
        if(prodotto.isEmpty()) return "redirect:/homepage";

        //prendo tra gli ordini l'unico non acquistato
        ArrayList<Ordine> ordini = repoOrdineDao.findByUtenteAndIsBought(utente, false);
        if((!ordini.isEmpty()))
            carrello = ordini.get(0);
        else{
            carrello = new Ordine();
            carrello.setUtente(utente);
            repoOrdineDao.save(carrello);
        }


        //prendo i piatti perché se non lo sveglio lui mi odia
        ArrayList<OrdineRecord> piatti = repoOrdineRecordDao.findByOrdine(carrello);

        for(OrdineRecord or: piatti){
            if(or.getProdotto().getId().equals(id)) return "redirect:/piatto?id="+id;

        }
        //svolgo le varie operazioni necessarie a carrello
        OrdineRecord record = new OrdineRecord(
                carrello, prodotto.get(), quantita
        );

        //salvo tutto al db
        repoOrdineRecordDao.save(record);
        utente = repoUtenteDao.findByMail(utente.getMail());
        session.setAttribute("loggedUser", utente);

        return "redirect:/piatto?id="+id;
    }

}
