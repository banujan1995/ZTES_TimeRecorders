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
	 * Neue aktiven User registrieren. (BR)
	 */

	@PostMapping(path = "/timerecorders/registeruser/", produces = "application/json")
	public boolean registerUser(@RequestBody MessageLoginUserActivity registeruser) {
		logger.info("Mitarbeiter ist eingeloggt - wurde in der AktivitätsOnlineListe aufgenommen");

		boolean notRegistered = false;

		List<LoginUserActivityRegister> userOnlineList = loginUserActivityRegisterInterface.findAll();
		LoginUserActivityRegister newUser = new LoginUserActivityRegister();
		System.out.println("Die Grösse der Liste beträgt " + userOnlineList.size());

		if (userOnlineList.size() != 0) {
			for (int i = 0; i < userOnlineList.size(); i++) {

				if (userOnlineList.get(i).getUsername().equalsIgnoreCase(registeruser.getUsername())) {

					logger.info("Anmeldung von neuen Aktivitätsuser wurde nicht erfasst!");
					notRegistered = false;

				} else {
					logger.info("Anmeldung von neuen Aktivitätsuser wurde erfasst!");
					newUser.setUsername(registeruser.getUsername());
					newUser = loginUserActivityRegisterInterface.save(newUser);

					notRegistered = true;
					break;

				}

			}

		} else {
			logger.info("Anmeldung von neuen Aktivitätsuser wurde erfasst!");
			newUser.setUsername(registeruser.getUsername());
			newUser = loginUserActivityRegisterInterface.save(newUser);
			notRegistered = true;

		}

		return notRegistered;

	}


	// User loggt sich aus und wird von der Liste entfernt(BR)

		@PostMapping(path = "/timerecorders/deleteuser/", produces = "application/json")
		public boolean deleteUser(@RequestBody MessageLoginUserActivity deleteuser) {
			logger.info("Mitarbeiter wurde ausgeloggt - Mitarbeiter wurde aus der Liste gelöscht.");

			boolean userIsInActiveList = false; 


			List<LoginUserActivityRegister> userOnline = loginUserActivityRegisterInterface.findAll();
			
			System.out.println("Kommt hier rein - deleteuser");

			for (LoginUserActivityRegister activeUser : userOnline) {
				if (activeUser.getUsername() == null)
				return userIsInActiveList = false;

				activeUser.setUsername("");
				userOnline.remove(activeUser);
				
				loginUserActivityRegisterInterface.save(activeUser);
				
				logger.info("Aktive User wurde gelöscht");
				return userIsInActiveList = true;
				}
				return userIsInActiveList;
		}
	
	}

	
	
	
	
	


