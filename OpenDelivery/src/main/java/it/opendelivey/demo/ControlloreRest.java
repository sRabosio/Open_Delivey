package it.opendelivey.demo;

import it.opendelivey.demo.handlers.FavoritesHandler;
import it.opendelivey.demo.handlers.HomepageHandler;
import it.opendelivey.demo.handlers.ProfileHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlloreRest {

    //PPTX 4 di SpringBoot

    /*TODO: verificare che i dati siano corretti per evitare che
    *  i dati possano essere visti da qualcuno senza autorizzazione */


    @GetMapping("homepage")
    public Object getHomepage(
            @RequestParam("id") int id,
            @RequestParam("passowrd") String password,
            @RequestParam("op") String operation
    ){
        //TODO: algoritmo per scegliere il piatto da visualizzare (da fare nell'apposita classe, aka: non qua)


        return new HomepageHandler(operation, id, password);
    }



    @GetMapping("/favorites")
    public Object favorites(
            @RequestParam("id") int id,
            @RequestParam("password") String password,
            @RequestParam("op") String operation
    ){
        return new FavoritesHandler(operation, id, password);
    }

    @GetMapping("/profile")
    public Object profile(
            @RequestParam("passowrd") String password,
            @RequestParam("id") int id,
            @RequestParam("op") String operation
    ){
        return new ProfileHandler(operation, id, password);
    }

}
