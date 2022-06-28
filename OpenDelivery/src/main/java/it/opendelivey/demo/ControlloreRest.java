package it.opendelivey.demo;

import it.opendelivey.demo.dataStructures.Piatto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlloreRest {

    @GetMapping("homepage")
    public Object getConsigliato(
            @RequestParam("id") int id,
            @RequestParam("op") String operation
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare
        //TODO: gestire le operazioni
        //NB: usare solo l'id dell'utente è un problema di sicurezza, mettere anche la password come conferma?

        return Piatto.piattoSample();
    }



}
