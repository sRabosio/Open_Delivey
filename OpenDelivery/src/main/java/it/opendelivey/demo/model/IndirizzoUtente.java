package it.opendelivey.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class IndirizzoUtente {

    @NotNull @NotEmpty
    private String indirizzo, civico, cap, citta;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne @JoinColumn
    private Utente utente;

    public IndirizzoUtente(){}

    public IndirizzoUtente(String indirizzo, String civico, String cap, String citta) {
        this.indirizzo = indirizzo;
        this.civico = civico;
        this.cap = cap;
        this.citta = citta;
    }

    public IndirizzoUtente(String indirizzo, String civico, String cap, String citta, Integer id) {
        this.indirizzo = indirizzo;
        this.civico = civico;
        this.cap = cap;
        this.citta = citta;
        this.id = id;
    }

    public static IndirizzoUtente indirizzoUtenteSample(){
        return new IndirizzoUtente(
          "via magenta",
          "180",
          "20099",
          "sesto san giovanni",
                1
        );
    }

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

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndirizzoUtente that = (IndirizzoUtente) o;
        return Objects.equals(indirizzo, that.indirizzo) && Objects.equals(civico, that.civico) && Objects.equals(cap, that.cap) && Objects.equals(citta, that.citta);
    }
}
