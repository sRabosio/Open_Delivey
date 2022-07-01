package it.opendelivey.demo.handlers;

import it.opendelivey.demo.model.Utente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Superclasse per incapsulare i campi comuni degli handler
//che andremo a fare

public class Handler {
    @NotNull(message = "no operation error")
    @NotBlank(message = "no operation error")
    private String operation;

    @NotNull(message = "utente non trovato")
    private Utente utente;

    public Handler(String operation, int id, String password) {
        this.operation = operation;
        this.utente = verify(id, password);
    }
    
    private Utente verify(int id, String password){
        Utente dbUtente = Utente.utenteSample();
        
        if(id == dbUtente.getId() && password.equals(dbUtente.getpassword()))
            return dbUtente;
        else
            return null;
    }

    public Object exec(){
        return null;
    }

    protected String getOperation() {
        return operation;
    }

    protected Utente getUtente() {
        return utente;
    }

}
