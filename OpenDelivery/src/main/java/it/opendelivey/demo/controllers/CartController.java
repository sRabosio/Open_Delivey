package it.opendelivey.demo.controllers;

import it.opendelivey.demo.Repo.RepoIndirizzoUtente;
import it.opendelivey.demo.Repo.RepoOrdine;
import it.opendelivey.demo.Repo.RepoRecordOrdine;
import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.IndirizzoUtente;
import it.opendelivey.demo.model.Ordine;
import it.opendelivey.demo.model.OrdineRecord;
import it.opendelivey.demo.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Controller
public class CartController {

    @Autowired
    RepoOrdine repoOrdineDao;

    @Autowired
    RepoRecordOrdine repoRecordOrdineDao;

    @Autowired
    RepoIndirizzoUtente repoIndirizzoUtenteDao;

    @Autowired
    RepoUtente repoUtenteDao;

    @GetMapping("/cart")
    public String getCart(
            Model model,
            HttpSession session
    ){
        //ordine a null come valore iniziale x thymeleaf
        Set<OrdineRecord> carrello = null;

        //trovo l'utente
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        //prendo l'ordine ed estraggo i record
        ArrayList<Ordine> ordine = repoOrdineDao.findByUtenteAndIsBought(utente, false);
        if(ordine != null && ordine.size() > 0)
            if(ordine.get(0).getPiatti().size()>0)
               carrello = ordine.get(0).getPiatti();

        //prendo gli indirizzi dell'utente
        ArrayList<IndirizzoUtente> indirizziUtente = repoIndirizzoUtenteDao.findByUtente(utente);

        //mando tutto a thymeleaf
        model.addAttribute("utente", utente);
        model.addAttribute("carrello", carrello);
        model.addAttribute("indirizziUtente", indirizziUtente);

        return "cart";
    }

    @PostMapping("/cart/delete")
    public String cartDelete(
            HttpSession session,
            @RequestParam("recordId") Integer recordId
    ){
        //trovo l'utente
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        //prendo il record
        Optional<OrdineRecord> record = repoRecordOrdineDao.findById(recordId);
        if(record.isEmpty()) return "redirect:/cart";

        //lo cancello
        repoRecordOrdineDao.deleteById(recordId);
        return "redirect:/cart";
    }



    @PostMapping("/cart/remove")
    public String cartRemove(
            HttpSession session,
            @RequestParam("recordId") int recordId
    ){
        //trovo l'utente
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        //trovo il record
        Optional<OrdineRecord> record = repoRecordOrdineDao.findById(recordId);
        if(record.isEmpty()) return "redirect:cart";

        //faccio l'operazione
        if(record.get().getAmount() < 2){
            repoRecordOrdineDao.deleteById(recordId);
            return "redirect:/cart";
        }

        record.get().setAmount(
                record.get().getAmount()-1
        );
        repoRecordOrdineDao.save(record.get());
        return "redirect:/cart";
    }

    @PostMapping("/cart/add")
    public String cartAdd(
            HttpSession session,
            @RequestParam("recordId") int recordId
    ){
        //trovo l'utente
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        //prendo il record
        Optional<OrdineRecord> record = repoRecordOrdineDao.findById(recordId);
        if(record.isEmpty()) return "redirect:cart";

        //operazione
        record.get().setAmount(
                record.get().getAmount()+1
        );
        repoRecordOrdineDao.save(record.get());
        return "redirect:/cart";
    }

    @PostMapping("/cart/newAddress")
    public String newAddress(
            HttpSession session,
            IndirizzoUtente indirizzo
    ){
        //trovo l'utente
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";
        indirizzo.setUtente(utente);

        //salvo i nuovi dati
        ArrayList<IndirizzoUtente> indirizziUtente = repoIndirizzoUtenteDao.findByUtente(utente);
        for(IndirizzoUtente temp: indirizziUtente){
            if(temp.equals(indirizzo)) return "redirect:/cart";
        }

        utente.addIndirizzo(indirizzo);
        repoUtenteDao.save(utente);
        session.setAttribute("loggedUser", utente);
        return "redirect:/cart";
    }

    @PostMapping("/cart/buy")
    public String cartBuy(
            HttpSession session
    ){
        //trovo l'utente
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        //operazione
        Ordine ordine = repoOrdineDao.findByUtenteAndIsBought(utente, false).get(0);
        ordine.setBought(true);

        //salavataggio
        repoOrdineDao.save(
                new Ordine(utente)
        );
        utente = repoUtenteDao.findByMail(utente.getMail());
        session.setAttribute("loggedUser", utente);
        return "redirect:/paymentsuccessful";
    }

    @GetMapping("paymentsuccessful")
    public String paysuc(Model model,
                         HttpSession session){
        Utente utente = (Utente) session.getAttribute("loggedUser");
        if(!(Utente.validate(utente, repoUtenteDao))) return "redirect:/login";

        model.addAttribute("pagato", true);
        return "cart";
    }
}
