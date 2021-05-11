package ch.zt.timerecorders.view;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Kiren Gondal
 * @author Banujan Ragunathan
 *
 */

@Controller // Annotation für den Framework 
public class ViewsController {

	/**
	 * Methoden Annotation Kiren: html files anzeigen und richtig verlinken
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String showLogin(Model model) {

		return "login_de.html";
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

}
