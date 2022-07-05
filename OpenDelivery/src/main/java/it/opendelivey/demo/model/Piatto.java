package it.opendelivey.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Piatto {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    String nome;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    String descrizione;

    @NotNull
    @Min(1)
    double prezzo;

    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)
    Integer id;


    //TODO: relazione
    @NotNull
    String[] allergeni;

    public Piatto(int id, String nome, String descrizione, int prezzo, @NotNull String[] allergeni) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.allergeni = allergeni;
        this.id = id;
    }

    public static Piatto piattoSample(){
        return new Piatto(
                0,
                "piattone",
                "l'originale",
                15,
                new String[]{"lattosio", "arachidi"}
        );
    }

    public int getId() {
        return id;
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
