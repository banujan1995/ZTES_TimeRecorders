package ch.zt.timerecorders.view;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.zt.timerecorders.start.ServiceLocator;

/**
 * 
 * @author Kiren Gondal
 * @author Banujan Ragunathan
 *
 */

@Controller // Annotation für den Framework
public class ViewsController {

	// BR
	Logger logger = ServiceLocator.getServiceLocator().getLogger();

	/**
	 * Methoden Annotation Kiren: html files anzeigen und richtig verlinken
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String showLogin(Model model) {
		logger.info("Das erste HTML LOGIN-DE wurde geladen.");
		return "login_de.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/loginen")
	public String showLoginEng(Model model) {
		logger.info("Das HTML LOGIN-EN wurde geladen.");
		return "login_en.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/main")
	public String showMain(Model model) {
		logger.info("Das HTML MAIN-EN wurde geladen.");
		return "main_en.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/profile")
	public String showProfile(Model model) {
		logger.info("Das HTML PROFILE-EN wurde geladen.");
		return "profile_en.html";	
	}

	@RequestMapping(method = RequestMethod.GET, value = "/employeeList")
	public String showEmployeeList(Model model) {
		logger.info("Das HTML EmployeeList wurde geladen.");
		return "employeeList_en.html";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/addEmployee")
	public String showAddEmployee(Model model) {
		logger.info("Das HTML addEmployee wurde geladen.");
		return "addEmployee_en.html";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/report")
	public String showReport(Model model) {
		logger.info("Das HTML Report wurde geladen.");
		return "report_en.html";

	}

}
