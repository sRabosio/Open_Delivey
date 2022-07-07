package it.opendelivey.demo.Repo;

import it.opendelivey.demo.model.Ordine;
import it.opendelivey.demo.model.OrdineRecord;
import it.opendelivey.demo.model.Piatto;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RepoRecordOrdine extends CrudRepository<OrdineRecord, Integer> {
    ArrayList<RepoRecordOrdine> findByOrdine(Ordine ordine);
    ArrayList<RepoRecordOrdine> findByPiatto(Piatto piatto);
}
