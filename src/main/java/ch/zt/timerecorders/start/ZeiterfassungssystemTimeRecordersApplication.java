package ch.zt.timerecorders.start;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ch.zt.timerecorders.businesslogic.Pensum;
import ch.zt.timerecorders.persistence.Administrator;
import ch.zt.timerecorders.persistence.AdministratorenRepository;
import ch.zt.timerecorders.persistence.Mitarbeiter;
import ch.zt.timerecorders.persistence.MitarbeiterRepository;
import ch.zt.timerecorders.persistence.Zeiterfassung;
import ch.zt.timerecorders.persistence.Zeiterfassungsrepository;
import ch.zt.timerecorders.view.ViewsController;


@SpringBootApplication
@ComponentScan({ "ch.zt.timerecorders.persistence", "ch.zt.timerecorders.businesslogic", "ch.zt.timerecorders.services",
		"ch.zt.timerecorders.view", "ch.zt.timerecorders.start"  }) // Referenz, wenn es in den verschiedenen Packages ist. (BR)
public class ZeiterfassungssystemTimeRecordersApplication {
	
	@Autowired
	private ServiceLocator serviceLocator;
	
	@Autowired
	private MitarbeiterRepository mitarbeiterRepository;

	@Autowired
	private AdministratorenRepository administratorRepository;

	@Autowired
	private Zeiterfassungsrepository zeiterfassungsRepository;
	
	@Autowired 
	private MitarbeiterRepositoryInterface maRepo;
	
	

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
		Mitarbeiter mariaAndreas = new Mitarbeiter("Andreas", "Maria", "1234", Pensum.HundertProzent);
		Mitarbeiter kirenGondal = new Mitarbeiter("Gondal", "Kiren","1234", Pensum.HundertProzent);
		Mitarbeiter jordiSchmidlin = new Mitarbeiter("Schmidlin", "Jordi", "1234", Pensum.HundertProzent);
		Mitarbeiter banujanRagunathan = new Mitarbeiter("Ragunathan", "Banujan","1234", Pensum.HundertProzent);
		mitarbeiterRepository.addMitarbeiter(mariaAndreas);
		mitarbeiterRepository.addMitarbeiter(kirenGondal);
		mitarbeiterRepository.addMitarbeiter(jordiSchmidlin);
		mitarbeiterRepository.addMitarbeiter(banujanRagunathan);

//		Administrator lukasFrey = new Administrator("Lukas","Frey", 8.24, 122.0);
//		Administrator richardBradley = new Administrator("Richard","Bradley", 8.24, 122.0);
//		administratorRepository.addAdministrator(lukasFrey);
//		administratorRepository.addAdministrator(richardBradley);	
	}

}
