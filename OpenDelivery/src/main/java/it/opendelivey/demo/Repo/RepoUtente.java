package it.opendelivey.demo.Repo;
import it.opendelivey.demo.Repo.RepoUtente;
import it.opendelivey.demo.model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepoUtente extends CrudRepository<Utente, Integer> {
    Utente findByEmail(String email);
    Utente findByPassword(String password);

}

