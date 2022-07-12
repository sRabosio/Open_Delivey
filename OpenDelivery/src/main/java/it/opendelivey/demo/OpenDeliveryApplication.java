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

		repoUtenteDao.deleteAll();

		//Optional<Ristorante> r = repoRistorante.findById(1);


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
		Allergene funghi = new Allergene("funghi");

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
		repoAllergeneDao.save(funghi);

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
				new Allergie("molluschi"),
				new Allergie("funghi")
		};

		repoAllergieDao.saveAll(Arrays.stream(allergie).toList());

		Ristorante ristorante = new Ristorante(
				"Odissea21",
				"123456789",
				new Tipo[]{
						pizzeria
				}
		);

		ristorante = repoRistoranteDao.save(ristorante);
		IndirizzoRistorante indirizzoRistorante = new IndirizzoRistorante(
				"Via Cesare da Sesto",
				"90",
				"20099",
				"sesto san giovanni"
		);

		indirizzoRistorante.setRistorante(ristorante);
		indirizzoRistorante = repoIndirizzoRistoranteDao.save(indirizzoRistorante);

		ArrayList<Piatto> piatti = new ArrayList<>();

		piatti.add(new Piatto("margerita", "pizza margherita classica", 4.0, new Allergene[]{
				latte,
				glutine
		}));

		piatti.add(new Piatto("marinara", "pizza", 4.0, new Allergene[]{
				glutine
		}));

		piatti.add(
				new Piatto("primavera", "pizza", 6.0, new Allergene[]{
						latte,
						glutine
				})
		);

		piatti.add(new Piatto("4 formaggi", "pizza", 5.0, new Allergene[]{
				latte,
				glutine
		}));

		piatti.add(new Piatto("boscaiola", "pizza margherita classica", 8.0, new Allergene[]{
				latte,
				glutine
		}));

		piatti.add(new Piatto("odissea", "pizza senza glutine", 6.0, new Allergene[]{
				glutine
		}));

		piatti.add(new Piatto("farcita", "pizza margherita classica", 5.20, new Allergene[]{
				latte,
				glutine,
				funghi
		}));

		piatti.add(new Piatto("salsiccia", "S A L S I C C I A", 5.50, new Allergene[]{
				latte,
				glutine
		}));

		for(Piatto p: piatti)
			p.addRistorante(ristorante);

		piatti = (ArrayList<Piatto>) repoPiattoDao.saveAll(piatti);
		ristorante.setProdotti(new HashSet<>(piatti));
		ristorante = repoRistoranteDao.save(ristorante);

		//TODO: r2

		ristorante = new Ristorante(
				"Jubin Due",
				"123456789",
				new Tipo[]{
						ristoranteTipo
				}
		);

		ristorante = repoRistoranteDao.save(ristorante);
		indirizzoRistorante = new IndirizzoRistorante(
				"Via Padova",
				"7",
				"20127",
				"milano"
		);

		indirizzoRistorante.setRistorante(ristorante);
		indirizzoRistorante = repoIndirizzoRistoranteDao.save(indirizzoRistorante);

		piatti = new ArrayList<>();

		piatti.add(new Piatto("involtini vietnamiti", "ho chi minh", 4.0, new Allergene[]{
				glutine,
				uova,
				sedano
		}));

		piatti.add(new Piatto("ravioli di gamberi", "gambo ro", 5.0, new Allergene[]{
				glutine,
				crostacei
		}));

		piatti.add(
				new Piatto("poplette di pesce", "pesciolone", 8.50, new Allergene[]{
						latte,
						glutine,
						uova,
						pesce
				})
		);

		piatti.add(new Piatto("riso saltato alla cantonese", "riso almeno 5 caratteriraibfsi", 4.50, new Allergene[]{
				latte,
				glutine
		}));

		piatti.add(new Piatto("pollo con le mandorle", "BOLLO almeno 5 caratteriraibfsi", 7.0, new Allergene[]{
				frutta_a_guscio
		}));

		for(Piatto p: piatti)
			p.addRistorante(ristorante);

		piatti = (ArrayList<Piatto>) repoPiattoDao.saveAll(piatti);
		ristorante.setProdotti(new HashSet<>(piatti));
		ristorante = repoRistoranteDao.save(ristorante);


		//TODO: r3

		ristorante = new Ristorante(
				"Ristorante l'Ostricaro",
				"123456789",
				new Tipo[]{
						ristoranteTipo
				}
		);

		ristorante = repoRistoranteDao.save(ristorante);
		indirizzoRistorante = new IndirizzoRistorante(
				"Via Don Giovanni Minzoni",
				"80",
				"20099",
				"sesto san giovanni"
		);

		indirizzoRistorante.setRistorante(ristorante);
		indirizzoRistorante = repoIndirizzoRistoranteDao.save(indirizzoRistorante);

		piatti = new ArrayList<>();

		piatti.add(new Piatto("tartare di tonno", "con sedano e cipolla", 10.0, new Allergene[]{
				glutine,
				sedano,
				pesce
		}));

		piatti.add(new Piatto("carapaccio di tonno fresco", "TONNO FRESCO!", 7.0, new Allergene[]{
				pesce
		}));

		piatti.add(
				new Piatto("tagliolini all'aragosta", "aragostona", 15.0, new Allergene[]{
						latte,
						glutine,
						crostacei
				})
		);

		piatti.add(new Piatto("pappardelle al salmone e caviale", "uova di pesce asd asd asd asd asd", 20.0, new Allergene[]{
				glutine,
				pesce
		}));

		piatti.add(new Piatto("pasta al granchio", "chi di granchio, granchio", 15.0, new Allergene[]{
				glutine,
				crostacei,
				latte
		}));

		for(Piatto p: piatti)
			p.addRistorante(ristorante);

		piatti = (ArrayList<Piatto>) repoPiattoDao.saveAll(piatti);
		ristorante.setProdotti(new HashSet<>(piatti));
		ristorante = repoRistoranteDao.save(ristorante);

	}

}
