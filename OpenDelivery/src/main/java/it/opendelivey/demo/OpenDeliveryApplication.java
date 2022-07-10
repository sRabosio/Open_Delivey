package it.opendelivey.demo;

import it.opendelivey.demo.Repo.*;
import it.opendelivey.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class OpenDeliveryApplication implements CommandLineRunner {

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

	@Autowired
	RepoAllergene repoAllergeneDao;

	@Override
	public void run(String... args) throws Exception {

		/*Optional<Ristorante> r = repoRistorante.findById(1);

		IndirizzoRistorante i = IndirizzoRistorante.indirizzoRistoranteSample();
		i.setRistorante(r.get());
		repoIndirizzoRistoranteDao.save(i);

		//repoUtenteDao.deleteAll();

		/*Ristorante r = Ristorante.ristoranteSample();

		Tipo buffet = new Tipo("buffet");
		Tipo fastFood = new Tipo("fast food");
		Tipo mensa = new Tipo("mensa");
		Tipo osteria = new Tipo("osteria");
		Tipo paninoteca = new Tipo("paninoteca");
		Tipo pizzeria = new Tipo("pizzeria");
		Tipo ristoranteTipo = new Tipo("ristorante");
		Tipo selfService = new Tipo("self service");
		Tipo taverna = new Tipo("taverna");
		Tipo tavolaCalda = new Tipo("tavola calda");
		Tipo trattoria = new Tipo("trattoria");

		repoTipoDao.save(buffet);
		repoTipoDao.save(fastFood);
		repoTipoDao.save(osteria);
		repoTipoDao.save(paninoteca);
		repoTipoDao.save(ristoranteTipo);
		repoTipoDao.save(mensa);
		repoTipoDao.save(selfService);
		repoTipoDao.save(taverna);
		repoTipoDao.save(tavolaCalda);
		repoTipoDao.save(trattoria);
		repoTipoDao.save(pizzeria);

		r.addTipologia(pizzeria);

		Allergene glutine = new Allergene("glutine");
		Allergene crostacei = new Allergene("crostacei");
		Allergene uova = new Allergene("uova");
		Allergene pesce = new Allergene("pesce");
		Allergene arachidi = new Allergene("arachidi");
		Allergene soia = new Allergene("soia");
		Allergene latte = new Allergene("latte");
		Allergene frutta_a_guscio = new Allergene("frutta a guscio");
		Allergene sedano = new Allergene("sedano");
		Allergene senape = new Allergene("senape");
		Allergene sesamo = new Allergene("sesamo");
		Allergene lupino =	new Allergene("lupino");
		Allergene molluschi = new Allergene("molluschi");

		repoAllergeneDao.save(glutine);
		repoAllergeneDao.save(crostacei);
		repoAllergeneDao.save(uova);
		repoAllergeneDao.save(pesce);
		repoAllergeneDao.save(arachidi);
		repoAllergeneDao.save(soia);
		repoAllergeneDao.save(latte);
		repoAllergeneDao.save(frutta_a_guscio);
		repoAllergeneDao.save(sedano);
		repoAllergeneDao.save(senape);
		repoAllergeneDao.save(sesamo);
		repoAllergeneDao.save(lupino);
		repoAllergeneDao.save(molluschi);

		Allergie[] allergie = {
				new Allergie("glutine"),
				new Allergie("crostacei"),
				new Allergie("uova"),
				new Allergie("pesce"),
				new Allergie("arachidi"),
				new Allergie("soia"),
				new Allergie("latte"),
				new Allergie("frutta a guscio"),
				new Allergie("sedano"),
				new Allergie("seanape"),
				new Allergie("sesamo"),
				new Allergie("lupino"),
				new Allergie("molluschi")
		};

		repoAllergieDao.saveAll(Arrays.stream(allergie).toList());

		Ristorante ristorante = Ristorante.ristoranteSample();
		repoRistoranteDao.save(ristorante);

		Piatto[] piatti = {
			new Piatto("margerita", "pizza margherita classica", 4.0, new Allergene[]{
				latte,
				glutine
			}),
				new Piatto("marinara", "pizza", 4.0, new Allergene[]{
						glutine
				}),
				new Piatto("primavera", "pizza", 6.0, new Allergene[]{
						latte,
						glutine
				}),
				new Piatto("4 formaggi", "pizza", 5.0, new Allergene[]{
						latte,
						glutine
				}),
				new Piatto("boscaiola", "pizza margherita classica", 8.0, new Allergene[]{
						latte,
						glutine
				})
		};

		repoPiattoDao.saveAll(Arrays.asList(piatti));

		Optional<Ristorante> r2 = repoRistorante.findById(1);

		ArrayList<Piatto> piatti2 = repoPiattoDao.findAll();

		for(Piatto p: piatti2){
			r2.get().addProdotto(p);
		}

		repoRistorante.save(r2.get());
		/*Ristorante ristorante2 = repoRistoranteDao.findById(2).get();

		Piatto[] piatti2 = {
				new Piatto("tagliolini all'aragosta", "sdfiljkbdfijb", 10.0, new Allergene[]{
						repoAllergeneDao.findByNome("glutine"),
						repoAllergeneDao.findByNome("crostacei")
				}),
				new Piatto("grigliata di pesce", "sdfiljkbdfijb", 20.0, new Allergene[]{
						repoAllergeneDao.findByNome("pesce")
				})
		};

		for(Piatto p: piatti2){
			p.addRistorante(ristorante2);
			repoPiattoDao.save(p);
		}*/

	}


}
