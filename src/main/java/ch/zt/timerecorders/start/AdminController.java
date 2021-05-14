package ch.zt.timerecorders.start;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Kiren Gondal
 */

@Controller
@RequestMapping("administrator")
public class AdminController {


		@Autowired
		private AdministratorServiceInterface admin;
//
//		@RequestMapping(method = RequestMethod.GET)
//		public String index(ModelMap modelMap) {
//			modelMap.put("admin", admin.findAll());
//			return "admin/index";
//		}
//		
		@GetMapping("/login") 
		   public String login(HttpServletRequest request, HttpSession session) { 
		      session.setAttribute(
		         "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
		      ); 
		      return "main_en";

}

		private String getErrorMessage(HttpServletRequest request, String key) {
		      Exception exception = (Exception) request.getSession().getAttribute(key); 
		      String error = ""; 
		      if (exception instanceof BadCredentialsException) { 
		         error = "Invalid username and password!"; 
		      } else if (exception instanceof LockedException) { 
		         error = exception.getMessage(); 
		      } else { 
		         error = "Invalid username and password!"; 
		      } 
		      return error;
}
	}
