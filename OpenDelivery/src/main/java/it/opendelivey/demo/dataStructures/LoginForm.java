package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginForm {
    @NotNull
    @NotBlank
    private String mail, password;

    public LoginForm(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }


    @Override
    public String toString() {
        return "LoginForm{" +
                "mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public static LoginForm testForm(){
        return new LoginForm("test@tmail.com", "password");
    }

}
