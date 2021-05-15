package ch.zt.timerecorders.start;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import ch.zt.timerecorders.businesslogic.Pensum;
import ch.zt.timerecorders.persistence.Administrator;
import ch.zt.timerecorders.persistence.AdministratorenRepository;
import ch.zt.timerecorders.persistence.Mitarbeiter;
import ch.zt.timerecorders.persistence.MitarbeiterRepository;
import ch.zt.timerecorders.persistence.Zeiterfassung;
import ch.zt.timerecorders.persistence.Zeiterfassungsrepository;
import ch.zt.timerecorders.view.ViewsController;


@SpringBootApplication
@ComponentScan({ "ch.zt.timerecorders.persistence", "ch.zt.timerecorders.persistence", "ch.zt.timerecorders.businesslogic", "ch.zt.timerecorders.services",
		"ch.zt.timerecorders.view", "ch.zt.timerecorders.start", "ch.zt.timerecorders.database"}) // Referenz, wenn es in den verschiedenen Packages ist. (BR)
public class ZeiterfassungssystemTimeRecordersApplication{
	
	@Autowired
	private ServiceLocator serviceLocator;
	
	@Autowired
	private MitarbeiterRepository mitarbeiterRepository;

	@Autowired
	private AdministratorenRepository administratorRepository;

	@Autowired
	private Zeiterfassungsrepository zeiterfassungsRepository;
	
	@Autowired 
	private MitarbeiterRepositoryInterface mitarbeiterRepositoryInterface;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ZeiterfassungssystemTimeRecordersApplication.class, args);
	}

	/*
	 * Wir machen Testdaten rein, damit wir es sehen können (BR) - am Schluss mit
	 * der Annotation der Start der Methode nach vollständigen Instanzierung der
	 * Klasse
	 */

	@PostConstruct
	public void createTestData() {
		Mitarbeiter mariaAndreas = new Mitarbeiter("Andreas", "Maria", "amaria", "1234", Pensum.HundertProzent);
		Mitarbeiter kirenGondal = new Mitarbeiter("Gondal", "Kiren", "gkiren","1234", Pensum.HundertProzent);
		Mitarbeiter jordiSchmidlin = new Mitarbeiter("Schmidlin", "Jordi", "sjordi", "1234", Pensum.HundertProzent);
		Mitarbeiter banujanRagunathan = new Mitarbeiter("Ragunathan", "Banujan", "rbanujan","1234", Pensum.HundertProzent);
		mitarbeiterRepository.addMitarbeiter(mariaAndreas);
		mitarbeiterRepository.addMitarbeiter(kirenGondal);
		mitarbeiterRepository.addMitarbeiter(jordiSchmidlin);
		mitarbeiterRepository.addMitarbeiter(banujanRagunathan);

		Administrator lukasFrey = new Administrator("Frey","Lukas", "flukas", "1234", Pensum.HundertProzent);
		Administrator richardBradley = new Administrator("Bradley","Richard", "brichard", "1234", Pensum.HundertProzent);
		administratorRepository.addAdministrator(lukasFrey);
		administratorRepository.addAdministrator(richardBradley);	
	}


}
