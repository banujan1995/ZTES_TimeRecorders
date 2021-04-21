package ch.zt.timerecorders.services;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zt.timerecorders.businesslogic.Mitarbeiter;
import ch.zt.timerecorders.persistence.MitarbeiterRepository;

/**
 * 
 * @author Banujan Ragunathan
 *
 */

@RestController // Annotation für Restservice für Framework (BR)
public class MitarbeiterListService {
	
	@Autowired
	private MitarbeiterRepository mitarbeiterRepository;

	/**
	 * Methoden Annotation (BR) - MIT GET MIT PARAMETER - Rückgabewert JSON Methode
	 * für den HTTP Request - nicht BusinessLogic (BR)
	 */

	
//	@GetMapping(path = "/timerecorders/erfasstemitarbeiter", produces = "application/json") 
//	public List<Mitarbeiter> getlistMitarbeiter(@RequestParam(required = false) String filter) { // Filter Framework
//		return mitarbeiterRepository.getMitarbeiterList();
////		System.out.println(mitarbeiterRepository.getMitarbeiterList().get(0));
//	}

	@GetMapping(path = "/timerecorders/erfasstemitarbeiter", produces = "application/json") 
	public List<Mitarbeiter> getlistMitarbeiter() { // Filter Framework
		return mitarbeiterRepository.getMitarbeiterList();
//		return mitarbeiterRepository.findAll(); //Falls wir Repository Annotation für internen Service brauchen!


	}

}
