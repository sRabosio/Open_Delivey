package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.*;
import it.opendelivey.demo.model.*;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

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

        Optional<Piatto> prodotto = repoPiattoDao.findById(id);
        if(prodotto.isEmpty()) return "redirect:/homepage";

        model.addAttribute("prodotto", prodotto.get());
        model.addAttribute("allergeni", prodotto.get().getAllergeni());

        return "plate";
    }

    @PostMapping("/piatto/add")
    public String addPiatto(
            @RequestParam("id") Integer id,
            @RequestParam("q") int quantità,
            HttpSession session
    ){
        if(quantità < 1) return "redirect:/piatto";

        //prendo utente
        ArrayList<Tipo> filter = (ArrayList<Tipo>) session.getAttribute("filter");
        Utente utente = (Utente)session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        //prendo il piatto da inserire
        Optional<Piatto> prodotto = repoPiattoDao.findById(id);
        if(prodotto.isEmpty()) return "redirect:/homepage";

        //prendo tra gli ordini l'unico non acquistato
        Ordine carrello = null;
        ArrayList<Ordine> ordini = repoOrdineDao.findByUtenteAndIsBought(utente, false);

        carrello = ordini.get(0);

        //se l'utente non ha ordini o ha solo ordini che ha già acquistato ne creo uno nuovo
        if(carrello == null) {
            carrello = new Ordine();
            carrello.setUtente(utente);
        }

        //prendo i piatti perché se non lo sveglio lui mi odia
        ArrayList<OrdineRecord> piatti = repoOrdineRecordDao.findByOrdine(carrello);

        for(OrdineRecord or: piatti){
            if(or.getProdotto().getId().equals(id)) return "redirect:/piatto?id="+id;

        }
        //svolgo le varie operazioni necessarie a carrello
        OrdineRecord record = new OrdineRecord(
                carrello, prodotto.get(), quantità
        );

        //salvo tutto al db
        repoOrdineRecordDao.save(record);
        utente = repoUtenteDao.findByMail(utente.getMail());
        session.setAttribute("loggedUser", utente);

        return "redirect:/piatto?id="+id;
    }

}
