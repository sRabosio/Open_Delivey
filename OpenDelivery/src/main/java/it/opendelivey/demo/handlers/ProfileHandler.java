package it.opendelivey.demo.handlers;

import it.opendelivey.demo.model.Utente;

public class ProfileHandler extends Handler{


    public ProfileHandler(String operation, int id, String password) {
        super(operation, id, password);
    }

    public Object exec(){
        switch (getOperation()){
            case "view":
                return view();
                
            default:
                return -1;
        }
    }

    private Utente view() {
        return getUtente();
    }
}
