package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Piatto;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Set;

public interface RepoPiatto extends CrudRepository<Piatto, Integer> {
    ArrayList<Piatto> findAll();
}
