package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.IndirizzoUtente;
import it.opendelivey.demo.model.Utente;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RepoIndirizzoUtente extends CrudRepository<IndirizzoUtente, Integer> {
    ArrayList<IndirizzoUtente> findAll();
    ArrayList<IndirizzoUtente> findByUtente(Utente utente);
}
