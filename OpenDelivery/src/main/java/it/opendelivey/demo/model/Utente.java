package it.opendelivey.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

    public String getpassword() {
        return password;
    }
}
