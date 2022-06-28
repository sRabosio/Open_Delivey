package it.opendelivey.demo.dataStructures;

import it.opendelivey.demo.dataStructures.Piatto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Offerta {
    @NotNull @Positive
    private int id;

    String nome, descrizione;

    @NotNull @Min(1)
    private double prezzo;

    @NotNull
    private Piatto[] piatti;

    public Offerta(int id, double prezzo, @NotNull Piatto[] piatti) {
        this.id = id;
        this.prezzo = prezzo;
        this.piatti = piatti;
    }

    public static Offerta offertaSample(){
        Offerta off = new Offerta(0, 15,
                new Piatto[]{Piatto.piattoSample()});
        off.setNome("offertona");
        off.setDescrizione("non perdertela");
        return off;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Piatto[] getPiatti() {
        return piatti;
    }

    public void setPiatti(Piatto[] piatti) {
        this.piatti = piatti;
    }
}
