package it.opendelivey.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Arrays;

//TODO: implementare annotazione ibernate

public class Utente {
    private String nome,
        cognome,
        password,
        mail;
    private String[] allergie;
    private Integer eta;
    private Indirizzo indirizzo;
    @NotNull @Positive
    private Integer id;

    private Piatto[] preferiti,
        carrello, recentPlates;

    private String recentSearches;

    public Utente(Integer id) {
        this.id = id;
    }

    public static Utente utenteSample(){
        Utente u = new Utente(0);
        u.setAllergie(
                new String[]{"albania"}
        );
        u.setEta(19);
        u.setCognome("castoro");
        u.setNome("pollo");
        u.setMail("testmail@tmail.com");
        u.setIndirizzo(Indirizzo.indirizzo());
        u.setPassword("password");

        return u;
    }


    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", allergie=" + Arrays.toString(allergie) +
                ", eta=" + eta +
                ", indirizzo=" + indirizzo +
                ", id=" + id +
                ", preferiti=" + Arrays.toString(preferiti) +
                ", carrello=" + Arrays.toString(carrello) +
                ", recentPlates=" + Arrays.toString(recentPlates) +
                ", recentSearches='" + recentSearches + '\'' +
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

    public String[] getAllergie() {
        return allergie;
    }

    public void setAllergie(String[] allergie) {
        this.allergie = allergie;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Piatto[] getPreferiti() {
        return preferiti;
    }

    public Piatto[] getCarrello() {
        return carrello;
    }

    public Piatto[] getRecentPlates() {
        return recentPlates;
    }

    public String getRecentSearches() {
        return recentSearches;
    }

    public void setPreferiti(Piatto[] preferiti) {
        this.preferiti = preferiti;
    }

    public void setCarrello(Piatto[] carrello) {
        this.carrello = carrello;
    }

    public void setRecentPlates(Piatto[] recentPlates) {
        this.recentPlates = recentPlates;
    }

    public void setRecentSearches(String recentSearches) {
        this.recentSearches = recentSearches;
    }
}
