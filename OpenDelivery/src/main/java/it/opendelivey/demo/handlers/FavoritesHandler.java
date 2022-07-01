package it.opendelivey.demo.handlers;

import it.opendelivey.demo.dataStructures.Piatto;
import it.opendelivey.demo.dataStructures.Utente;

import javax.validation.constraints.NotNull;

public class FavoritesHandler extends Handler{

    public FavoritesHandler(String operation, int id, String password) {
        super(operation, id, password);
    }

    @Override
    public Object exec() {
        switch (getOperation()){

            case "favorites":
                return favorites();

            default:
                return -1;
        }
    }

    //ritorna la lista dei piatti preferiti da un utente
    private Piatto[] favorites() {
        return new Piatto[]{
            Piatto.piattoSample(),
            Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
                Piatto.piattoSample(),
        };
    }
}
