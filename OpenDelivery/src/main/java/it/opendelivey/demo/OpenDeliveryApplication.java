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
	RepoAllergie repoAllergieDao;
	@Autowired
	RepoTipo repoTipoDao;
	@Autowired
	RepoOrdine repoOrdineDao;
	@Autowired
	RepoRecordOrdine repoRecordOrdineDao;
	@Autowired
	RepoIndirizzoUtente repoIndirizzoUtenteDao;
	@Autowired
	RepoIndirizzoRistorante repoIndirizzoRistoranteDao;

	@Autowired
	RepoRistorante repoRistoranteDao;

	@Override
	public void run(String... args) throws Exception {

		Ordine ordine = Ordine.ordineSample();
		ordine.setUtente(
				Utente.utenteSample()
		);

		Piatto p = Piatto.piattoSample();
		p.addRistorante(Ristorante.ristoranteSample());
		repoPiattoDao.save(p);
	}


}
