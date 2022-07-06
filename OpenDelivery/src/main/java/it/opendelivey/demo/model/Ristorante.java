package it.opendelivey.demo.model;

import it.opendelivey.demo.Repo.RepoRistorante;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ristorante {
    @NotNull
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    @Size(min = 3)
    private String nome;
    @NotNull
    private String categoria;
    @NotNull
    private String menu;
    @NotNull
    private String indirizzo;

    public Ristorante() {
    }



    public Ristorante(String nome, String categoria, String menu, String indirizzo) {

        this.nome = nome;
        this.categoria = categoria;
        this.menu = menu;
        this.indirizzo = indirizzo;
    }


    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public static Ristorante ristoranteSample(){
        Ristorante ri = new Ristorante();
        ri.setNome("napoliuaglio");
        ri.setCategoria("pizzeria");
        ri.setIndirizzo("VIA ROMA 52");
        ri.setMenu("napoli , margherita");
        return ri;

    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
