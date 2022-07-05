package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Ristorante;
import org.springframework.data.repository.CrudRepository;

public interface RepoRistorante extends CrudRepository<Ristorante, Integer> {
}
