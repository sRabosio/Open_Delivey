package it.opendelivey.demo.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//TODO: implementare annotazione ibernate
@Entity
public class Utente {
    @NotNull @Size(max = 45, min = 3)
    private String nome,
        cognome;

    @NotNull @Size(max = 45, min = 8)
    private String password;

    @NotNull @Size(max = 64, min = 8)
    private String mail;

    @NotNull
    private Integer eta;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private Set<Ordine> ordini = new HashSet<>();

    @ManyToMany @JoinColumn
    private Set<Allergie> allergie = new HashSet<>();

    @OneToMany(mappedBy = "utente")
    private Set<IndirizzoUtente> indirizzi = new HashSet<>();

    private String imagePath;

    public Utente() {
    }

    public static Utente utenteSample(){
        Utente u = new Utente();
        u.setEta(19);
        u.setCognome("castoro");
        u.setNome("pollo");
        u.setMail("testmail@tmail.com");
        u.setPassword("password");
        u.setId(1);
        return u;
    }

    public void addIndirizzo(IndirizzoUtente indirizzo) {
        indirizzi.add(indirizzo);
    }


    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                //", allergie=" + Arrays.toString(allergie) +
                ", eta=" + eta +
                //", indirizzo=" + indirizzo +
                ", id=" + id +
                /*", preferiti=" + Arrays.toString(preferiti) +
                ", carrello=" + Arrays.toString(carrello) +
                ", recentPlates=" + Arrays.toString(recentPlates) +*/
                //", recentSearches='" + recentSearches + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Allergie> getAllergie() {
        return allergie;
    }

    public void setAllergie(Set<Allergie> allergie) {
        this.allergie = allergie;
    }

    public Set<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(Set<Ordine> ordini) {
        this.ordini = ordini;
    }

    public Set<IndirizzoUtente> getIndirizzi() {
        return indirizzi;
    }

    public void setIndirizzi(Set<IndirizzoUtente> indirizzi) {
        this.indirizzi = indirizzi;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
