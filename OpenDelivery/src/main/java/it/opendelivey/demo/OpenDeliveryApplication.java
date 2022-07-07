package it.opendelivey.demo;

import it.opendelivey.demo.Repo.*;
import it.opendelivey.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication
public class OpenDeliveryApplication implements CommandLineRunner {

	//TODO: usare il create-drop per testare le query
	//TODO: aggiungere il framework per gestire il database

	public static void main(String[] args) {
		SpringApplication.run(OpenDeliveryApplication.class, args);
	}

	@Autowired
	RepoUtente repoUtenteDao;
	@Autowired
	RepoPiatto repoPiattoDao;
	@Autowired
	RepoRistorante repoRistorante;
	@Autowired
	RepoIndirizzo repoIndirizzoDao;
	@Autowired
	RepoAllergie repoAllergieDao;
	@Autowired
	RepoTipo repoTipoDao;
	@Autowired
	RepoOrdine repoOrdineDao;

	@Override
	public void run(String... args) throws Exception {
		repoUtenteDao.save(Utente.utenteSample());
		repoPiattoDao.save(Piatto.piattoSample());
		repoOrdineDao.save(Ordine.ordineSample());
	}


}
