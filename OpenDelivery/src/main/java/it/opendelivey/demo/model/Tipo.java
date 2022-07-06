package it.opendelivey.demo.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tipo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String nome;

    @ManyToMany(mappedBy = "tipologie")
    private Set<Ristorante> ristoranti = new HashSet<>();

    public Tipo() {
    }

    public Tipo( String nome) {
        this.nome = nome;
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
    public static it.opendelivey.demo.model.Tipo tipoSample(){
        return new it.opendelivey.demo.model.Tipo(
                "pizza"
        );
    }
}