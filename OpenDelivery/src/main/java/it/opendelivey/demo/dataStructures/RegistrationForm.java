package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    @Size(min=2, message = "il nome deve contenere almeno 2 caratteri")
    private String nome;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    @Size(min=2, message = "il cognome deve mantenere almeno 2 caratteri")
    private String cognome;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private String mail;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    @Size(min=5, message = "la password deve contenere almeno 5 caratteri")
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
