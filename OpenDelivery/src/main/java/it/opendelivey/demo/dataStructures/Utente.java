package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.NotNull;

public class Utente {
    private String nome,
        cognome,
        password,
        mail;
    private String[] allergie;
    private int eta;
    private Indirizzo indirizzo;
    @NotNull
    private int id;

    public Utente(int id) {
        this.id = id;
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
}
