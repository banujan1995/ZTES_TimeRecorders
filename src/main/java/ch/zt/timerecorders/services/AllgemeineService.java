package ch.zt.timerecorders.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zt.timerecorders.persistence.AdministratorenRepository;
import ch.zt.timerecorders.persistence.ArbeitstagRepository;
import ch.zt.timerecorders.persistence.MitarbeiterRepository;
import ch.zt.timerecorders.start.AddAbsenceRepositoryInterface;
import ch.zt.timerecorders.start.MitarbeiterRegister;
import ch.zt.timerecorders.start.MitarbeiterRepositoryInterface;
import ch.zt.timerecorders.start.ServiceLocator;
import ch.zt.timerecorders.start.TimeStampRegisterChangeInterface;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */
@RestController // Annotation für Restservice für Framework (BR)
public class AllgemeineService {

	Logger logger = ServiceLocator.getServiceLocator().getLogger();

	@Autowired
	private MitarbeiterRepository mitarbeiterRepository;

	@Autowired
	private AdministratorenRepository administratorenRepository;

	@Autowired
	private ArbeitstagRepository arbeitstagRepository;

	@Autowired
	private MitarbeiterRepositoryInterface mitarbeiterRepositoryInterface;

	@Autowired
	private TimeStampRegisterChangeInterface timeStampRegisterChange;

	@Autowired
	private AddAbsenceRepositoryInterface absenceRepo;

	/*
	 * Hier wird ausfindig gemacht, ob Mitarbeiter die Adminfunktion haben darf oder
	 * nicht und dazu wird er über diese Funktion den weiteren Klasse gegeben.(BR)
	 */

	// https://qastack.com.de/programming/30895286/spring-mvc-how-to-return-simple-string-as-json-in-rest-controller
	@GetMapping(path = "/timerecorders/roleofworker/{username}/", produces = "application/json")
	public Map<String, String> getRoleOfWorker(@PathVariable String username) {

		String role = "";
		List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();

		for (MitarbeiterRegister ml : ma) {
			if (ml.getUsername().equalsIgnoreCase(username)) {

				role = ml.getRole();
				logger.info("Rolle des Mitarbeiters gefunden.");
				break;

			} else {

				logger.info("Rolle des Mitarbeiters nicht gefunden.");
			}

		}

		return Collections.singletonMap(role, role);

	}

	/*
	 * Hier wird das Pensum des Mitarbeiters als Service an den anderen Klassen
	 * übergeben (KG).
	 */

	// https://qastack.com.de/programming/30895286/spring-mvc-how-to-return-simple-string-as-json-in-rest-controller
	@GetMapping(path = "/timerecorders/pensumOfWorker/{username}/", produces = "application/json")
	public Map<String, String> getPensumOfWorker(@PathVariable String username) {

		String pensum = "";
		List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();

		for (MitarbeiterRegister ml : ma) {
			if (ml.getUsername().equalsIgnoreCase(username)) {

				pensum = ml.getPensum();
				logger.info("Pensum des Mitarbeiters gefunden.");
				break;

			} else {
				logger.info("Pensum des Mitarbeiters nicht gefunden.");
			}

		}

		return Collections.singletonMap(pensum, pensum);

	}

}
