package ch.zt.timerecorders.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zt.timerecorders.businesslogic.Administrator;
import ch.zt.timerecorders.persistence.AdministratorenRepository;

/**
 * 
 * @author Banujan Ragunathan
 *
 */

@RestController
public class AdministratorenListService {

	@Autowired
	private AdministratorenRepository administratorenRepository;

	/**
	 * Methoden Annotation (BR) - MIT GET MIT PARAMETER - Rückgabewert JSON Methode
	 * für den HTTP Request - nicht BusinessLogic (BR)
	 */

	
	@GetMapping(path = "/timerecorders/erfassteadministratoren", produces = "application/json")
	public List<Administrator> getListAdministrator() { // Filter Framework
		return administratorenRepository.getAdministratorList();
//		return mitarbeiterRepository.findAll(); //Falls wir Repository Annotation für internen Service brauchen!
	}

}
