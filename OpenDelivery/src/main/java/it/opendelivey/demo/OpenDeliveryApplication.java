package it.opendelivey.demo;

import it.opendelivey.demo.Repo.*;
import it.opendelivey.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Arrays;

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
				repoUtenteDao.findByMail("rabosiosimone@gmail.com")
		);
		ordine.setBought(false);
		repoOrdineDao.save(ordine);
		Piatto p = Piatto.piattoSample();
		repoRistoranteDao.save(Ristorante.ristoranteSample());
		p.addRistorante(Ristorante.ristoranteSample());
		repoPiattoDao.save(p);
		OrdineRecord or = new OrdineRecord(
				ordine,
				p,
				5
		);
		repoRecordOrdineDao.save(or);
		/*Allergie[] allergie = {
				new Allergie("lattosio"),
				new Allergie("glutine"),
				new Allergie("arachidi"),
				new Allergie("soia"),
				new Allergie("uova"),
				new Allergie("senape"),
				new Allergie("molluschi")
		};
		repoAllergieDao.saveAll(Arrays.stream(allergie).toList());*/
	}


}
