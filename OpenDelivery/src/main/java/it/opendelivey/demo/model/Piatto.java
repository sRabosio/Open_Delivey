package it.opendelivey.demo.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Table(name = "prodotti")
public class Piatto {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String nome;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 50)
    private String descrizione;

    @NotNull
    @DecimalMin("1.0")
    private Double prezzo;


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(mappedBy = "piatti", cascade = CascadeType.ALL)
    private Set<Ordine> ordini = new HashSet<>();

    //TODO: relazione allergeni

    public Piatto() {
    }

    public Piatto(String nome, String descrizione, Double prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public static Piatto piattoSample(){
        return new Piatto(
                "piattone",
                "l'originale",
                15.0
        );
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

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
