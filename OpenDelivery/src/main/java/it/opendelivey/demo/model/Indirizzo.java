package it.opendelivey.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Indirizzo {
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private String tipo;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private String via;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private Integer cap;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private String civico;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private String paese;

    public Indirizzo(String via, int cap, String civico, String paese) {
        this.via = via;
        this.cap = cap;
        this.civico = civico;
        this.paese = paese;
    }

    public static Indirizzo indirizzo(){
        return new Indirizzo(
                "via magenta",
                20099,
                "180",
                "italia"
        );
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "tipo='" + tipo + '\'' +
                ", via='" + via + '\'' +
                ", cap=" + cap +
                ", civico='" + civico + '\'' +
                ", paese='" + paese + '\'' +
                '}';
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }
}
