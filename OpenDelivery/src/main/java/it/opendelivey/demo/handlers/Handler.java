package it.opendelivey.demo.handlers;

import it.opendelivey.demo.dataStructures.Utente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Handler {
    @NotNull(message = "no operation error")
    @NotBlank(message = "no operation error")
    private String operation;

    @NotNull(message = "utente non trovato")
    private Utente utente;

    public Handler(String operation, Utente utente) {
        this.operation = operation;
        this.utente = utente;
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
