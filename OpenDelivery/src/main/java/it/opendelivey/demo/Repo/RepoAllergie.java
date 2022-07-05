package it.opendelivey.demo.Repo;
import it.opendelivey.demo.Repo.RepoIndirizzo;
import it.opendelivey.demo.model.Allergie;
import it.opendelivey.demo.model.Indirizzo;
import it.opendelivey.demo.model.Utente;
import org.springframework.data.repository.CrudRepository;

public interface RepoAllergie extends CrudRepository<Allergie, Integer> {
}

