package it.opendelivey.demo;

import it.opendelivey.demo.dataStructures.Piatto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlloreRest {

    @GetMapping("homepage")
    public Piatto getConsigliato(
            @RequestParam("idUtente") int id,
            @RequestParam("op") String operation
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare
        //TODO: gestire le operazioni

        return Piatto.piattoSample();
    }



}
