package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Utente {
    private String nome,
        cognome,
        password,
        mail;
    private String[] allergie;
    private int eta;
    private Indirizzo indirizzo;
    @NotNull @Positive
    private int id;

    private Piatto[] preferiti,
        carrello, recentPlates;

    private String recentSearches;

    public Utente(int id) {
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

    public int getId() {
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
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
