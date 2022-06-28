package it.opendelivey.demo;

import it.opendelivey.demo.dataStructures.Piatto;
import it.opendelivey.demo.dataStructures.Utente;
import it.opendelivey.demo.handlers.FavoritesHandler;
import it.opendelivey.demo.handlers.HomepageHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlloreRest {

    //PPTX 4 di SpringBoot

    @GetMapping("homepage")
    public Object getHomepage(
            @RequestParam("id") int id,
            @RequestParam("op") String operation
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare
        //TODO: gestire le operazioni
        //NB: usare solo l'id dell'utente è un problema di sicurezza, mettere anche la password come conferma?


        return new HomepageHandler(operation, Utente.utenteSample()).exec();
    }



    @GetMapping("/favorites")
    public Object favorites(
            @RequestParam("id") int id,
            @RequestParam("op") String operation
    ){
        return new FavoritesHandler(operation, Utente.utenteSample()).exec();
    }

}
