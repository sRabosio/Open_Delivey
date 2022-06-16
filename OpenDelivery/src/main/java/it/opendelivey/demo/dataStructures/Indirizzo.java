package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Indirizzo {
    @NotNull
    @NotBlank
    private String tipo;
    @NotNull
    @NotBlank
    private String via;
    @NotNull
    @NotBlank
    private int cap;
    @NotNull
    @NotBlank
    private String civico;
    @NotNull
    @NotBlank
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
