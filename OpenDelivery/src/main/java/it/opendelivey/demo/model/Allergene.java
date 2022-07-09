package it.opendelivey.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
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
}
