package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Piatto;
import it.opendelivey.demo.model.Ristorante;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RepoRistorante extends CrudRepository<Ristorante, Integer> {
    ArrayList<Ristorante> findAll();
    ArrayList<Ristorante> findByNomeContains(String query);
}
