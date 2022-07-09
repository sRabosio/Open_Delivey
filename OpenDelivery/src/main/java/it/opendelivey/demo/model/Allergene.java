package it.opendelivey.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Allergene{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String nome;

    public Allergene() {
    }

    public Allergene(String nome) {
        this.nome = nome;
    }

    @ManyToMany(mappedBy = "allergeni")
    private Set<Piatto> prodotti = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Piatto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(Set<Piatto> prodotti) {
        this.prodotti = prodotti;
    }
}
