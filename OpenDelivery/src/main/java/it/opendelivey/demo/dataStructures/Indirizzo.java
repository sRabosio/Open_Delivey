package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.NotNull;

public class Indirizzo {
    @NotNull
    private String tipo;
    @NotNull
    private String via;
    @NotNull
    private int cap;
    @NotNull
    private String civico;
    @NotNull
    private String paese;

    public Indirizzo(String via, int cap, String civico, String città, String paese) {
        this.via = via;
        this.cap = cap;
        this.civico = civico;
        this.paese = paese;
    }


    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }
}
