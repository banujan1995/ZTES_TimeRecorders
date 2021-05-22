package ch.zt.timerecorders.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zt.timerecorders.persistence.AdministratorenRepository;
import ch.zt.timerecorders.persistence.ArbeitstagRepository;
import ch.zt.timerecorders.persistence.Mitarbeiter;
import ch.zt.timerecorders.persistence.MitarbeiterRepository;
import ch.zt.timerecorders.start.LoginUserActivityRegister;
import ch.zt.timerecorders.start.LoginUserActivityRegisterInterface;
import ch.zt.timerecorders.start.MitarbeiterRegister;
import ch.zt.timerecorders.start.MitarbeiterRepositoryInterface;
import ch.zt.timerecorders.start.ServiceLocator;
import ch.zt.timerecorders.start.TimeStampRegisterChange;
import ch.zt.timerecorders.start.TimeStampRegisterChangeInterface;

/**
 * 
 * @author Banujan Ragunathan
 * @author Jordi Schmidlin
 *
 */

/*
 * Hier soll die Anmeldeaktivitäten von den User notiert werden. Es wird eine
 * Liste geführt mit den Anmeldungen und bei einer Abmeldung wird der User aus
 * der Liste rausgenommen.
 */

@RestController
public class UserLoginActivityService {

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
	private LoginUserActivityRegisterInterface loginUserActivityRegisterInterface;

	/*
	 * Wir holen wir den User anhand der IPAdresse. (BR)
	 */
	@ResponseBody
	@GetMapping(path = "/timerecorders/getUserOnlineList/", produces = "application/json")
	public List<LoginUserActivityRegister> getUserByIP() { // Filter Framework

		List<LoginUserActivityRegister> userOnline = loginUserActivityRegisterInterface.findAll();
		logger.info(userOnline.toString() + "User Online wurden übergeben");

		return userOnline;
	}

	/*
	 * Neue IP Adresse mit den dazugehörigen User registrieren. (BR)
	 */

	@PostMapping(path = "/timerecorders/registeruser/", produces = "application/json")
	public boolean registerUser(@RequestBody MessageLoginUserActivity registeruser) {
		logger.info("Mitarbeiter ist eingeloggt - wurde in der AktivitätsOnlineListe aufgenommen");

		LoginUserActivityRegister newUser = new LoginUserActivityRegister();

		newUser.setIP(registeruser.getIP());
		newUser.setUsername(registeruser.getUsername());

		newUser = loginUserActivityRegisterInterface.save(newUser);
		logger.info("Anmeldung von neuen User wurde erfasst");
		return true;
	}

	// User loggt sich aus und wird von der Liste entfernt(BR)

	@PostMapping(path = "/timerecorders/deleteuser/", produces = "application/json")
	public boolean deleteUser(@RequestBody MessageLoginUserActivity deleteuser) {
		logger.info("Mitarbeiter wurde ausgeloggt - Mitarbeiter wurde aus der Liste gelöscht.");
		
		LoginUserActivityRegister localuser; 
		boolean userDeleted; 

		List<LoginUserActivityRegister> userOnline = loginUserActivityRegisterInterface.findAll();
		
		
		for(int i = 0; i < userOnline.size(); i++) {
			localuser = userOnline.get(i); 
			
			if(userOnline.get(i).getIP().equalsIgnoreCase(deleteuser.getIP()) && userOnline.get(i).getUsername().equalsIgnoreCase(deleteuser.getUsername())) {
				userOnline.remove(i);
				userDeleted = true;
			} else {
				userDeleted = false;
			}
			
			userOnline = loginUserActivityRegisterInterface.saveAll(userOnline);
				
			
		}
		
//		for (int x = 0; x < userOnline; x++ ) {
//			localuser = user; 
//			if(user.getIP().equalsIgnoreCase(deleteuser.getIP()) && user.getUsername().equalsIgnoreCase(deleteuser.getUsername())) {
//				userOnline.remove(user);
//			}
//		
//		}
//		loginUserActivityRegisterInterface.deleteAllInBatch(localuser);
		userOnline = loginUserActivityRegisterInterface.saveAll(userOnline);
			
		return true;
	
	
	}

	
	
	
	
	

}
