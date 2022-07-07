package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Ordine;
import it.opendelivey.demo.model.Utente;
import org.springframework.data.repository.CrudRepository;

public interface RepoOrdine extends CrudRepository<Ordine, Integer> {
    public Ordine findByUtente(Utente utente);
}
