package ch.zt.timerecorders.start;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import ch.zt.timerecorders.businesslogic.Administrator;
import ch.zt.timerecorders.persistence.AdministratorenRepository;
import ch.zt.timerecorders.persistence.MitarbeiterRepository;

@SpringBootApplication
@ComponentScan({"ch.zt.timerecorders.persistence", "ch.zt.timerecorders.businesslogic", "ch.zt.timerecorders.services", "views" }) //Referenz, wenn es in den verschiedenen Packages ist. (BR)
public class ZeiterfassungssystemTimeRecordersApplication {
	
	@Autowired
	private MitarbeiterRepository mitarbeiterRepository;
	
	@Autowired
	private AdministratorenRepository administratorRepository; 
	
	@Autowired
	private MitarbeiterRepositoryInterface mitarbeiterRepo; 
	


	
	public static void main(String[] args) {
		SpringApplication.run(ZeiterfassungssystemTimeRecordersApplication.class, args);
	}
	
	/*
	 * Wir machen Testdaten rein, damit wir es sehen können (BR) - am Schluss mit
	 * der Annotation der Start der Methode nach vollständigen Instanzierung der
	 * Klasse
	 */

//	@PostConstruct 
//	public void createTestData() {
//		Mitarbeiter mariaAndreas = new Mitarbeiter("Andreas", "Maria");	
//		Mitarbeiter kirenGondal = new Mitarbeiter("Gondal", "Kiren");	
//		Mitarbeiter jordiSchmidlin = new Mitarbeiter("Schmidlin", "Jordi");	
//		Mitarbeiter banujanRagunathan = new Mitarbeiter("Ragunathan", "Banujan");	
//		mitarbeiterRepository.addMitarbeiter(mariaAndreas);
//		mitarbeiterRepository.addMitarbeiter(kirenGondal);
//		mitarbeiterRepository.addMitarbeiter(jordiSchmidlin);
//		mitarbeiterRepository.addMitarbeiter(banujanRagunathan);
//		
//		
//		Administrator lukasFrey = new Administrator("Lukas","Frey");
//		Administrator richardBradley = new Administrator("Richard","Bradley");
//		administratorRepository.addAdministrator(lukasFrey);
//		administratorRepository.addAdministrator(richardBradley);	
//	}
	
	
	



}
