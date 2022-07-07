package it.opendelivey.demo.Repo;
import it.opendelivey.demo.model.Allergie;
import org.springframework.data.repository.CrudRepository;

public interface RepoAllergie extends CrudRepository<Allergie, Integer> {
}

