package it.opendelivey.demo.model;

import it.opendelivey.demo.Repo.RepoUtente;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.crypto.Data;
import java.util.*;

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

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Ordine> ordini = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)   @JoinColumn
    private Set<Allergie> allergie = new HashSet<>();

    @OneToMany(mappedBy = "utente",fetch = FetchType.EAGER)
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

    //controlla se l'utente esiste già nel database
    //usando mail e password
    public static boolean validate(Utente utente, RepoUtente repoUtenteDao){

        return utente != null &&
                repoUtenteDao.existsByMailAndPassword(
                        utente.getMail(), utente.getPassword());
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

    public void addOrdine(Ordine ordine){
        ordini.add(ordine);
    }

    public void addAllAllergie(ArrayList<Allergie> newAllergie){
        allergie.addAll(newAllergie);
    }

    public void addAllergie(Allergie allergia){
        allergie.add(allergia);
    }
}
