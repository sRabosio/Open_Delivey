package it.opendelivey.demo.controllers;

import it.opendelivey.demo.handlers.HomepageHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomepageController {

    /*TODO: verificare che i dati siano corretti per evitare che
     *  i dati possano essere visti da qualcuno senza autorizzazione */
    @GetMapping("homepage")
    public String getHomepage(
            @RequestParam("id") int id,
            @RequestParam("passowrd") String password,
            @RequestParam("op") String operation
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare (da fare nell'apposita classe, ovvero: non qua)

        return "homepage";
    }
}
