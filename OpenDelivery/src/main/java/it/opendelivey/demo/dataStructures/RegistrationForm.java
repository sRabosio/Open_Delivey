package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {
    @NotNull
    @NotBlank
    @Size(min=2)
    private String nome;
    @NotNull
    @NotBlank
    @Size(min=2)
    private String cognome;
    @NotNull
    @NotBlank
    private String mail;
    @NotNull
    @NotBlank
    @Size(min=5)
    private String password;
    private Indirizzo indirizzo;

    public RegistrationForm(String nome, String cognome, String mail, String password, Indirizzo indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.password = password;
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", indirizzo=" + indirizzo +
                '}';
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }
}
