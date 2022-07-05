package it.opendelivey.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Ristorante {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    private Indirizzo indirizzo;

    @NotNull
    private String[] categorie;

    private int id;


    private Piatto[] menu;

    public static Ristorante ristoranteSample(){
        Ristorante ri = new Ristorante("la bella ristoranta" ,0);
        ri.setCategorie(
                new String[]{"pizzeria", "ristorante"}
        );

        ri.setIndirizzo(Indirizzo.indirizzo());
        ri.setMenu(
                new Piatto[]{Piatto.piattoSample(), Piatto.piattoSample(), Piatto.piattoSample()}
        );

        return ri;
    }


    public Piatto[] getMenu() {
        return menu;
    }

    public void setMenu(Piatto[] menu) {
        this.menu = menu;
    }

    public Ristorante(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String[] getCategorie() {
        return categorie;
    }

    public void setCategorie(String[] categorie) {
        this.categorie = categorie;
    }

    public int getId() {
        return id;
    }
}
