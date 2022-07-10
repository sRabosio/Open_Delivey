package it.opendelivey.demo.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Table(name = "prodotti")
public class Piatto {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
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

    @OneToMany(mappedBy = "prodotto")
    private Set<OrdineRecord> ordini = new HashSet<>();

    @ManyToMany(mappedBy = "prodotti")
    private Set<Ristorante> ristoranti = new HashSet<>();

    @ManyToMany @JoinColumn
    private Set<Allergene> allergeni = new HashSet<>();

    private String imagePath;


    public boolean hasAllergia(Allergie a){
        for(Allergene allergene:allergeni)
            if(allergene.getNome().equals(a.getNome())) return true;
        return false;
    }

    //TODO: relazione allergeni

    public Piatto() {
    }

    public Piatto(String nome, String descrizione, Double prezzo) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public Piatto(String nome, String descrizione, Double prezzo, Allergene[] allergenes) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        allergeni.addAll(List.of(allergenes));
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

    public Set<Ristorante> getRistoranti() {
        return ristoranti;
    }

    public void setRistoranti(Set<Ristorante> ristoranti) {
        this.ristoranti = ristoranti;
    }

    public Set<Allergene> getAllergeni() {
        return allergeni;
    }

    public void setAllergeni(Set<Allergene> allergeni) {
        this.allergeni = allergeni;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void addRistorante(Ristorante ristorante){
        ristoranti.add(ristorante);
    }

    public static Piatto piattoSample(){
        Piatto piatto = new Piatto();
        piatto.setNome("pollo fritto");
        piatto.setDescrizione("il grande pollone");
        piatto.setPrezzo(8);
        return piatto;
    }
}
