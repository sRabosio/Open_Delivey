//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package it.opendelivey.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Indirizzo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Integer id;
    @NotNull(
            message = "questo campo è obbligatorio"
    )
    @NotBlank(
            message = "questo campo è obbligatorio"
    )
    @Size(
            max = 64,
            min = 6
    )
    private String via;
    @NotNull(
            message = "questo campo è obbligatorio"
    )
    @NotBlank(
            message = "questo campo è obbligatorio"
    )
    @Size(
            min = 5,
            max = 5
    )
    private String cap;
    @NotNull(
            message = "questo campo è obbligatorio"
    )
    @NotBlank(
            message = "questo campo è obbligatorio"
    )
    @Size(
            min = 1,
            max = 10
    )
    private String civico;

    public Indirizzo() {
    }

    public Indirizzo(String via, String cap, String civico) {
        this.via = via;
        this.cap = cap;
        this.civico = civico;
    }

    public static Indirizzo indirizzoSample() {
        return new Indirizzo("via magenta", "20099", "180");
    }

    public String toString() {
        return "Indirizzo{, via='" + this.via + "', cap=" + this.cap + ", civico='" + this.civico + "'}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }
}
