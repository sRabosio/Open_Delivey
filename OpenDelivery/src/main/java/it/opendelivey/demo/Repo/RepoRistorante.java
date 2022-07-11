package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Piatto;
import it.opendelivey.demo.model.Ristorante;
import it.opendelivey.demo.model.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Set;

public interface RepoRistorante extends CrudRepository<Ristorante, Integer> {
    ArrayList<Ristorante> findAll();
    ArrayList<Ristorante> findByNomeContains(String query);
    ArrayList<Ristorante> findByTipologieIn(ArrayList<Tipo> tipologie);
}
