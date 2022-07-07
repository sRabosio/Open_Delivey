package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.IndirizzoRistorante;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RepoIndirizzoRistorante extends CrudRepository<IndirizzoRistorante, Integer> {
    ArrayList<IndirizzoRistorante> findAll();
}
