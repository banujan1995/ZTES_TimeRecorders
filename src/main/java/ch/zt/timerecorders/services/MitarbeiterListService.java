package ch.zt.timerecorders.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zt.timerecorders.persistence.Mitarbeiter;
import ch.zt.timerecorders.persistence.MitarbeiterRepository;
import ch.zt.timerecorders.persistence.Zeiterfassungsrepository;
import ch.zt.timerecorders.start.ServiceLocator;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */
@Controller // Annotation für Restservice für Framework (BR)
public class MitarbeiterListService {
	
	Logger logger = ServiceLocator.getServiceLocator().getLogger();

	@Autowired
	private MitarbeiterRepository mitarbeiterRepository;

	@Autowired
	private Zeiterfassungsrepository zeiterfassungsrepository;

	/**
	 * Methoden Annotation (BR) - MIT GET MIT PARAMETER - Rückgabewert JSON Methode
	 * für den HTTP Request - nicht BusinessLogic (BR)
	 */

	/**
	 * CRUD Methoden, um Mitarbeiter zu erfassen, mutieren, verändern, löschen (BR)
	 */

	// Mitarbeiter erstellen (BR)


	// Mitarbeiter mutieren von MA zu AD (BR)


	// Mitarbeiter löschen (BR)

	/**
	 * Mitarbeiter verändern (BR) - je nach Daten eine anderen Code nötig
	 */

	// Veränderung Name (BR)


	// Veränderung Vorname (BR)


	// Veränderung Tagessollstunden (BR)



	/**
	 * Allgemeine internen Funktionen
	 */
	
	// Mitarbeiter auslesen (BR)
	
	

	// Mitarbeiter Liste auslesen (BR)

	@GetMapping(path = "/timerecorders/erfasstemitarbeiter", produces = "application/json")
	public List<Mitarbeiter> getlistMitarbeiter() { // Filter Framework
		logger.info("Liste erfasste Mitarbeiter geladen");
		return mitarbeiterRepository.getMitarbeiterList();

	}

	// Mitarbeiter Zeitregister auslesen(BR)

	// Mitarbeiter einzelne Zeitelement auslesen

	/**
	 * Funktionen für Mitarbeiter, welche von Mitarbeiter aufgeruft werden auf der
	 * Webapplikation (BR)
	 */

	// Mitarbeiter Login (BR)

	// Mitarbeiter Logout (BR)

	// Mitarbeiter einstempeln (BR)

	// Mitarbeiter ausstempeln (BR)

	// Mitarbeiter - Ferien erfassen (BR)

	// Mitarbeiter - Zeitplan aufrufen (BR)

	// Mitarbeiter - Monatsrapport aufrufen (BR)

}
