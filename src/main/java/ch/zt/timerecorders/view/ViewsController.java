package ch.zt.timerecorders.view;

import java.util.logging.Logger;

import javax.servlet.http.Cookie;

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
	 * Methoden Annotation html files anzeigen und richtig verlinken - alle HTML werden über diese Klasse gesteuert (KG)
	 * 
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String showLoginEng(Model model) {
		logger.info("Das HTML LOGIN-EN wurde geladen.");

		return "login.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/main")
	public String showMain(Model model) {
		logger.info("Das HTML MAIN-EN wurde geladen.");

		return "main.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/profile")
	public String showProfile(Model model) {
		logger.info("Das HTML PROFILE-EN wurde geladen.");
		return "profile.html";
	}


	@RequestMapping(method = RequestMethod.GET, value = "/employeeList")
	public String showEmployeeList(Model model) {
		logger.info("Das HTML EmployeeList wurde geladen.");
		return "employeeList.html";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/addemployee")
	public String showAddEmployee(Model model) {
		logger.info("Das HTML addEmployee wurde geladen.");
		return "addEmployee.html";

	}

	@RequestMapping(method = RequestMethod.GET, value = "/report")
	public String showReport(Model model) {
		logger.info("Das HTML Report wurde geladen.");
		return "report.html";

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/changepassword")
	public String changePassword(Model model) {
		logger.info("Das HTML Change wurde geladen.");
		return "changePassword.html";

 	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/absence")
		public String showAbsence(Model model) {
		logger.info("Das HTML Absencen wurde geladen.");
		return "absence.html";
 	}

	@RequestMapping(method = RequestMethod.GET, value = "/addabsence")
		public String showAddAbsence(Model model) {
		logger.info("Das HTML Absencen wurde geladen.");
		return "addAbsence.html";
 	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/accesserror")
	public String showLoginError(Model model) {
	logger.info("Das HTML Absencen wurde geladen.");
	return "error_403.html";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/changeUsername")
	public String showChangeUsername(Model model) {
	logger.info("Das HTML ChangeUsername wurde geladen.");
	return "changeUsername.html";
	}

}
