package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Piatto {
    @NotNull
    @NotBlank
    String nome;

    @NotNull
    @NotBlank
    String descrizione;

    @NotNull
    @Min(1)
    int prezzo;

    @NotNull
    String[] allergeni;

    public Piatto(String nome, String descrizione, int prezzo, @NotNull String[] allergeni) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.allergeni = allergeni;
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

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String[] getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(String[] allergeni) {
        this.allergeni = allergeni;
    }
}
