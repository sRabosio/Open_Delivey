package it.opendelivey.demo.model;

import it.opendelivey.demo.Repo.RepoRistorante;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ristorante {
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
    private String numero;
    @ManyToMany
    @JoinColumn
    private Set<Piatto> prodotti = new HashSet<>();

    @ManyToMany @JoinColumn
    private Set<Tipo> tipologie = new HashSet<>();

    @OneToMany(mappedBy = "ristorante")
    private Set<IndirizzoRistorante> indirizzi = new HashSet<>();

    private String imagePath;

    public Ristorante() {
    }



    public Ristorante(String nome, String categoria, String numero) {
        this.numero= numero;
        this.nome = nome;
        this.categoria = categoria;
    }

    public static Ristorante ristoranteSample(){
        Ristorante ri = new Ristorante();
        ri.setNome("napoliuaglio");
        ri.setCategoria("pizzeria");
        ri.setNumero("3926803723");
        ri.addIndirizzo(IndirizzoRistorante.indirizzoRistoranteSample());
        return ri;

    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Piatto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(Set<Piatto> prodotti) {
        this.prodotti = prodotti;
    }

    public Set<Tipo> getTipologie() {
        return tipologie;
    }

    public void setTipologie(Set<Tipo> tipologie) {
        this.tipologie = tipologie;
    }

    public Set<IndirizzoRistorante> getIndirizzi() {
        return indirizzi;
    }

    public void setIndirizzi(Set<IndirizzoRistorante> indirizzi) {
        this.indirizzi = indirizzi;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void addProdotto(Piatto piatto){
        prodotti.add(piatto);
    }

    public void addIndirizzo(IndirizzoRistorante indirizzoRistorante){
        indirizzi.add(indirizzoRistorante);
    }

}
