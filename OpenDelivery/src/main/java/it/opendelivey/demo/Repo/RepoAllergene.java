package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Allergene;
import org.springframework.data.repository.CrudRepository;

public interface RepoAllergene extends CrudRepository<Allergene, Integer> {
    boolean existsByNome(String nome);
    Allergene findByNome(String nome);
}
