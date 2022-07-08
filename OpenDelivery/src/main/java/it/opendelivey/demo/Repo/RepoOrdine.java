package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Ordine;
import it.opendelivey.demo.model.Utente;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RepoOrdine extends CrudRepository<Ordine, Integer> {
    public ArrayList<Ordine> findByUtente(Utente utente);
    public ArrayList<Ordine> findByUtenteAndIsBought(Utente utente, boolean bought);
}
