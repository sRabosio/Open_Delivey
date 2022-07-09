package it.opendelivey.demo.Repo;
import it.opendelivey.demo.model.Allergie;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RepoAllergie extends CrudRepository<Allergie, Integer> {
    ArrayList<Allergie> findAll();
    ArrayList<Allergie> findAllById(Iterable<Integer> ids);
}

