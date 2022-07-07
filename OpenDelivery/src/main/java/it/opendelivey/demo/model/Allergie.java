package it.opendelivey.demo.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Allergie {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String nome;

    @ManyToMany(mappedBy = "allergie")
    private Set<Utente> utenti = new HashSet<>();

    public Allergie() {
    }

    public Allergie(Integer id, String nome, Set<Utente> utenti) {
        this.id = id;
        this.nome = nome;
        this.utenti = utenti;
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

}