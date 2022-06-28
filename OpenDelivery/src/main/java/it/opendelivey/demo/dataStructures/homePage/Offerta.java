package it.opendelivey.demo.dataStructures.homePage;

import it.opendelivey.demo.dataStructures.Piatto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Offerta {
    @NotNull @Positive
    private int id;

    String nome, descrizione;

    @NotNull @Min(1)
    private double prezzo;

    @NotNull
    private Piatto[] piatti;
}
