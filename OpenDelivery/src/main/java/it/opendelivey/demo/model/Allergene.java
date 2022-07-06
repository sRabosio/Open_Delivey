package it.opendelivey.demo.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

public class Allergene extends Allergie{

    @ManyToMany(mappedBy = "allergeni")
    private Set<Piatto> prodotti = new HashSet<>();
}
