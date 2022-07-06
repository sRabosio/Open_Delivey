package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Ordine;
import org.springframework.data.repository.CrudRepository;

public interface RepoOrdine extends CrudRepository<Ordine, Integer> {
}
