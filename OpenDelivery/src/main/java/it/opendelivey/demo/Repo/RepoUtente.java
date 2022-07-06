package it.opendelivey.demo.Repo;
import it.opendelivey.demo.model.Utente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RepoUtente extends CrudRepository<Utente, Integer> {
    /*List<Utente> findByMail(String mail);
    Optional<Utente> findById(Integer id);
    List<Utente> findByPassword(String password);*/
}

