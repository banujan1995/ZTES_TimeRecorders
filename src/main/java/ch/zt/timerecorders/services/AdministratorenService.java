package ch.zt.timerecorders.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zt.timerecorders.persistence.Administrator;
import ch.zt.timerecorders.persistence.AdministratorenRepository;
import ch.zt.timerecorders.persistence.ArbeitstagRepository;
import ch.zt.timerecorders.start.ServiceLocator;

/**
 * 
 * @author Banujan Ragunathan
 *
 */

@RestController
public class AdministratorenService {
	
	Logger logger = ServiceLocator.getServiceLocator().getLogger();


	@Autowired
	private AdministratorenRepository administratorenRepository;
	
	@Autowired
	private ArbeitstagRepository arbeitstagRepository; 
		
	
	/**
	 * Methoden Annotation (BR) - MIT GET MIT PARAMETER - Rückgabewert JSON Methode
	 * für den HTTP Request - nicht BusinessLogic (BR)
	 */

	@GetMapping(path = "/timerecorders/erfassteadministratoren", produces = "application/json")
	public List<Administrator> getListAdministrator() { // Filter Framework
		return administratorenRepository.getAdministratorList();
//		return mitarbeiterRepository.findAll(); //Falls wir Repository Annotation für internen Service brauchen!
	}

	/**
	 * CRUD Methoden, um Administrator zu erfassen, mutieren, verändern, löschen
	 * (BR)
	 */

	// Administrator erstellen (BR)
	
	// Administrator mutieren von AD zu MA

	// Administrator Daten verändern

	// Administrator löschen
	
	/**
	 * Allgemeine internen Funktionen
	 */
	
	//Administrator Liste auslesen (BR)
	
	@GetMapping(path = "/timerecorders/erfassteadministrators", produces = "application/json")
	public List<Administrator> getlistAdministrators() { // Filter Framework
		return administratorenRepository.getAdministratorList();
	}
	
	
	//Administrator Zeitregister auslesen(BR)
	
	
	//Administrator einzelne Zeitelement auslesen
	


	/**
	 * Funktionen für Administrator, welche von Administrator auf der Webapplikation
	 * (BR)
	 */
	// Administrator Login (BR)

	// Administrator Logout (BR)

	// Administrator einstempeln (BR)

	// Administrator ausstempeln (BR)

	// Administrator - Ferien erfassen (BR)

	// Administrator - Zeitplan aufrufen (BR)

	// Administrator - Monatsrapport aufrufen (BR)

}
