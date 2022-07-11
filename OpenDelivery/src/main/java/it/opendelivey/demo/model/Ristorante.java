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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private Set<Piatto> prodotti = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE) @JoinColumn
    private Set<Tipo> tipologie = new HashSet<>();

    @OneToOne(mappedBy = "ristorante", cascade = CascadeType.ALL)
    private IndirizzoRistorante indirizzo;

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
        ri.setIndirizzo(IndirizzoRistorante.indirizzoRistoranteSample());
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void addProdotto(Piatto piatto){
        prodotti.add(piatto);
    }

    public void addTipologia(Tipo tipo){
        tipologie.add(tipo);
    }

    public IndirizzoRistorante getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(IndirizzoRistorante indirizzo) {
        this.indirizzo = indirizzo;
    }

    //per qualche dannato motive l'equals non funziona
    public boolean hasTipo(Tipo tipo){
        for(Tipo tht: tipologie){
            if(tht.getId().equals(tipo.getId()))
                return true;
        }
        return false;
    }

    public String getPriceRange(){
        double avg = 0;
        for(Piatto p:prodotti)
            avg += p.getPrezzo();

        avg /= prodotti.size();

        if(avg <= 10) return "low";
        if(avg <= 20) return "medium";
        if(avg >20) return "high";

        return null;
    }

}
