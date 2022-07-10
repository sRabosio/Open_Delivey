package it.opendelivey.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
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
    private String numero;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private Set<Piatto> prodotti = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER) @JoinColumn
    private Set<Tipo> tipologie = new HashSet<>();

    @OneToMany(mappedBy = "ristorante")
    private Set<IndirizzoRistorante> indirizzi = new HashSet<>();

    private String imagePath;

    public Ristorante() {
    }



    public Ristorante(String nome, String numero, Tipo[] tipi) {
        this.nome = nome;
        this.numero = numero;
        tipologie.addAll(List.of(tipi));
    }

    public static Ristorante ristoranteSample(){
        Ristorante ri = new Ristorante();
        ri.setNome("napoliuaglio");
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

    public void addTipologia(Tipo tipo){
        tipologie.add(tipo);
    }


    //per qualche dannato motive l'equals non funziona
    public boolean hasTipo(Tipo tipo){
        for(Tipo tht: tipologie){
            if(tht.getId().equals(tipo.getId()))
                return true;
        }
        return false;
    }

}
