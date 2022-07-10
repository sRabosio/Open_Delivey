package it.opendelivey.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class IndirizzoRistorante {

    @NotNull
    @NotEmpty
    private String indirizzo, civico, cap,citta ;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    public Ristorante ristorante;

    public IndirizzoRistorante(String indirizzo, String civico, String cap, String citta) {
        this.indirizzo = indirizzo;
        this.civico = civico;
        this.cap = cap;
        this.citta =citta ;
    }

    public Ristorante getRistorante() {
        return ristorante;
    }

    public void setRistorante(Ristorante ristorante) {
        this.ristorante = ristorante;
    }

    public IndirizzoRistorante(){};

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String get() {
        return citta;
    }

    public void set(String citta) {
        this.citta =citta ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static IndirizzoRistorante indirizzoRistoranteSample(){
        return new IndirizzoRistorante(
                "via ristorante",
                "38",
                "93933",
                "citta dei ristoranti"
        );
    }
}
