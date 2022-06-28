package it.opendelivey.demo.handlers;

import it.opendelivey.demo.dataStructures.Offerta;
import it.opendelivey.demo.dataStructures.Piatto;
import it.opendelivey.demo.dataStructures.Ristorante;
import it.opendelivey.demo.dataStructures.Utente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HomepageHandler extends  Handler{


    public HomepageHandler(String operation, Utente utente) {
        super(operation, utente);
    }

    //seleziono l'operazione e la eseguo
    public Object exec(){
        switch (getOperation()){
            case "piatto":
                return piattoConsigliato();

            case "ristorante":
                return ristoranteConsigliato();

            case "categorie":
                return categories();

            case "offerte":
                return offerte();

            default:
                return -1;
        }
    }

    private Offerta[] offerte() {
        return new Offerta[]{
                Offerta.offertaSample(),
                Offerta.offertaSample(),
                Offerta.offertaSample(),
                Offerta.offertaSample(),
                Offerta.offertaSample(),
        };
    }

    private String[] categories() {
        //TODO: pull data from database
        return new String[]{"pizza", "vegetariano", "vegano"};
    }

    private Ristorante ristoranteConsigliato(){
        //TODO: algoritmo di selezione ristorante
        return Ristorante.ristoranteSample();
    }

    private Piatto piattoConsigliato(){
        //TODO: algoritmo di selezione piatto
        return Piatto.piattoSample();
    }
}
