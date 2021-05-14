package ch.zt.timerecorders.start;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.zt.timerecorders.persistence.MitarbeiterRepository;



/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */
@Controller// Annotation für Restservice für Framework (BR)
public class MitarbeiterService {
	
	
//	Logger logger = LoggerFactory.getLogger(MitarbeiterListService.class);
	
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
	
	/**
	 * Methoden Annotation Kiren: html files anzeigen und richtig verlinken
	 * 
	 */
	
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String showLogin(Model model) {
		
		return "addEmployee.html";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/loginen")
	public String showLoginEng(Model model) {
		
		return "login_en.html";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/main")
	public String showMain(Model model) {
		
		return "main_en.html";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/profile")
	public String showProfile(Model model) {
		
		return "profile_en.html";
	}
	
	@GetMapping(path = "/timerecorders/erfasstemitarbeiter", produces = "application/json") 
	public List<Mitarbeiter> getlistMitarbeiter() { // Filter Framework
		return mitarbeiterRepository.getMitarbeiterList();


	}
}
	

