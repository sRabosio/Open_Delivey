package it.opendelivey.demo.dataStructures;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class Piatto {
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private String Nome;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private Double Prezzo;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private Integer Quantità;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private ArrayList<String> Ingredienti;
    @NotNull(message = "questo campo è obbligatorio")
    @NotBlank(message = "questo campo è obbligatorio")
    private ArrayList<String> Intolleranze;


    public Piatto(String nome, Double prezzo, Integer quantità, ArrayList<String> ingredienti, ArrayList<String> intolleranze) {
        Nome = nome;
        Prezzo = prezzo;
        Quantità = quantità;
        Ingredienti = ingredienti;
        Intolleranze = intolleranze;
    }

    @Override
    public String toString() {
        return "Piatto{" +
                "Nome='" + Nome + '\'' +
                ", Prezzo=" + Prezzo +
                ", Quantità=" + Quantità +
                ", Ingredienti=" + Ingredienti +
                ", Intolleranze=" + Intolleranze +
                '}';
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Double getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(Double prezzo) {
        Prezzo = prezzo;
    }

    public Integer getQuantità() {
        return Quantità;
    }

    public void setQuantità(Integer quantità) {
        Quantità = quantità;
    }

    public ArrayList<String> getIngredienti() {
        return Ingredienti;
    }

    public void setIngredienti(ArrayList<String> ingredienti) {
        Ingredienti = ingredienti;
    }

    public ArrayList<String> getIntolleranze() {
        return Intolleranze;
    }

    public void setIntolleranze(ArrayList<String> intolleranze) {
        Intolleranze = intolleranze;
    }
}
