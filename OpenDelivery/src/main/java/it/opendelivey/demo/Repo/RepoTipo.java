package it.opendelivey.demo.Repo;
import it.opendelivey.demo.model.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RepoTipo extends CrudRepository<Tipo, Integer> {
    ArrayList<Tipo> findAll();
}

