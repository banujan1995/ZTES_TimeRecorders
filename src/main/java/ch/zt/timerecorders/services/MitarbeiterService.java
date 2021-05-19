package ch.zt.timerecorders.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.zt.timerecorders.persistence.Administrator;
import ch.zt.timerecorders.persistence.AdministratorenRepository;
import ch.zt.timerecorders.persistence.Arbeitstag;
import ch.zt.timerecorders.persistence.ArbeitstagRepository;
import ch.zt.timerecorders.persistence.Mitarbeiter;
import ch.zt.timerecorders.persistence.MitarbeiterRepository;
import ch.zt.timerecorders.start.MitarbeiterRegister;
import ch.zt.timerecorders.start.MitarbeiterRepositoryInterface;
import ch.zt.timerecorders.start.ServiceLocator;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */
@RestController // Annotation für Restservice für Framework (BR)
public class MitarbeiterService {

	Logger logger = ServiceLocator.getServiceLocator().getLogger();

	@Autowired
	private MitarbeiterRepository mitarbeiterRepository;

	@Autowired
	private AdministratorenRepository administratorenRepository;

	@Autowired
	private ArbeitstagRepository arbeitstagRepository;

	@Autowired
	private MitarbeiterRepositoryInterface mitarbeiterRepositoryInterface;

	/*
	 * Hier wird der Counter geführt, welcher für die Methode ins DB-Speichern
	 * dient. (BR)
	 */
	private int counterI = 0;
	private int counterY = 0;

	/**
	 * Methoden Annotation (BR) - MIT GET MIT PARAMETER - Rückgabewert JSON Methode
	 * für den HTTP Request - nicht BusinessLogic (BR)
	 */

	/**
	 * CRUD Methoden, um Mitarbeiter zu erfassen, mutieren, verändern, löschen (BR)
	 */

	// Mitarbeiter erstellen KG

	@PostMapping(path = "/addEmployee/", produces = "application/json")
	public long createNewMa(@RequestBody MessageMaRegister m) {

		MitarbeiterRegister m1 = new MitarbeiterRegister();
		m1.setSurname(m.getSurname());
		m1.setFamilyname(m.getFamilyname());
		m1.setName(m.getUsername());
		m1.setPasswort(m.getPasswort());
		m1.setPensum(m.getPensum());

		m1 = mitarbeiterRepositoryInterface.save(m1); // beim Speichern wird eine MAId automatisch vergeben
		logger.info("MA erfolgreich hinzugefügt");
		return m1.getMitarbeiterID();

	}

	// KG: MA Liste erstellen als JSON
	@ResponseBody
	@GetMapping(path = "/mitarbeiterList/", produces = "application/json")
	public List allMA() {

		List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();
		logger.info(ma.toString() + "Liste wurde erfolgreich erstellt");
		return ma;

	}

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

	@PostMapping(path = "/timerecorders/mitarbeiterlogin/", produces = "application/json")
	public boolean isValidUser(@RequestBody MessageMaRegister login) {

		List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();

		for (MitarbeiterRegister m : ma) {
			if (m.getUsername().equals(login.getUserame())) {
				logger.info("Mitarbeiter wurde gefunden");
				return true;

			} else {
				logger.info("Mitarbeiter wurde nicht gefunden");

			}

		}
		return false;

	}

	/*
	 * Mitarbeiter Login (BR) Hilfestellung bei der Lösung:
	 * https://stackoverflow.com/questions/11291933/requestbody-and-responsebody-
	 * annotations-in-spring
	 */

//	@PostMapping(path = "/timerecorders/mitarbeiterlogin/", produces = "application/json")
//	public boolean passwortCreaditalCheck(@RequestBody MessageLogin login) {
//
//		switch (adminORMaListFinder(login.getUser())) {
//
//		case "Mitarbeiter":
//
//			if (login.getPassword()
//					.equalsIgnoreCase(mitarbeiterRepository.getSingleMitarbeiterName(login.getUser()).getPasswort())) {
//				return true; 
//
//			} else {
//				return false;
//
//			}
//
//		case "Administrator":
//			if (login.getPassword().equalsIgnoreCase(
//					administratorenRepository.getSingleAdministratorName(login.getUser()).getPasswort())) {
//				return true;
//
//			} else {
//				return false;
//
//			}
//
//		default:
//			logger.warning("Es wurde ein Login eingegeben, welche nicht als Admin oder Mitarbeiter gibt "
//					+ "/ A login was entered which does not exist as an admin or employee.");
//			return false;
//		}
//
//	}

	/*
	 * Mitarbeiter Zeiterfassung (BR), Die Methode soll den korrekten Tag anhand der
	 * TagesID ins DB speichern.
	 */

	@PostMapping(path = "/timerecorders/zeiterfassung/", produces = "application/json")
	public boolean zeitenInServer(@RequestBody MessageTimeStamp zeiterfassung) {
		Arbeitstag workingday;
		boolean zeiterfassungGefunden = false;

		if (arbeitstagRepository.getZeiterfassungRepo().size() != 0) {
			Arbeitstag localArbeitstag;
			String localDate;

			for (counterI = 0; counterI < arbeitstagRepository.getZeiterfassungRepo().size(); counterI++) {

				for (counterY = 0; counterY < arbeitstagRepository.getZeiterfassungRepo().size(); counterY++) {
					localArbeitstag = arbeitstagRepository.getZeiterfassungRepo().get(counterI);
					localDate = arbeitstagRepository.getZeiterfassungRepo().get(counterI).getDate();

					if (localDate.equalsIgnoreCase(zeiterfassung.getDate())) {
						zeiterfassungGefunden = true;

					} else {
						zeiterfassungGefunden = false;

					}

				}
			}

			if (zeiterfassungGefunden) {
				// Vormittag Stunden
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitVormittagEndH(zeiterfassung.getMorningEndHours());
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitVormittagStartH(zeiterfassung.getMorningstartHours());

				// Vormittag Minuten
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitVormittagEndMin(zeiterfassung.getMorningEndMinDeci());
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitVormittagStartMin(zeiterfassung.getMorningStartMinDeci());

				// Summe Vormittag in Dezimal
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitNachmittagSummeHAndMin(zeiterfassung.getMorningTotal());

				// Nachmittag Stunden
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitNachmittagEndH(zeiterfassung.getAfternoonEndHours());
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitNachmittagStartH(zeiterfassung.getAfternoonStartHours());

				// Nachmittag Minuten
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitNachmittagEndMin(zeiterfassung.getAfternoonEndMinDeci());
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitNachmittagStartMin(zeiterfassung.getAfternoonStartMinDeci());

				// Summe Nachmittag in Dezimal
				arbeitstagRepository.getZeiterfassungRepo().get(counterI - 1)
						.setZeitNachmittagSummeHAndMin(zeiterfassung.getAfternoonTotal());

			} else if (!zeiterfassungGefunden) {
				workingday = new Arbeitstag((long) 1, zeiterfassung.getDate());

				// Vormittag Stunden
				workingday.setZeitVormittagEndH(zeiterfassung.getMorningEndHours());
				workingday.setZeitVormittagStartH(zeiterfassung.getMorningstartHours());

				// Vormittag Minuten
				workingday.setZeitVormittagEndMin(zeiterfassung.getMorningEndMinDeci());
				workingday.setZeitVormittagStartMin(zeiterfassung.getMorningStartMinDeci());

				// Summe Vormittag in Dezimal
				workingday.setZeitNachmittagSummeHAndMin(zeiterfassung.getMorningTotal());

				// Nachmittag Stunden
				workingday.setZeitNachmittagEndH(zeiterfassung.getAfternoonEndHours());
				workingday.setZeitNachmittagStartH(zeiterfassung.getAfternoonStartHours());

				// Nachmittag Minuten
				workingday.setZeitNachmittagEndMin(zeiterfassung.getAfternoonEndMinDeci());
				workingday.setZeitNachmittagStartMin(zeiterfassung.getAfternoonStartMinDeci());

				// Summe Nachmittag in Dezimal
				workingday.setZeitNachmittagSummeHAndMin(zeiterfassung.getAfternoonTotal());

				arbeitstagRepository.addZeiterfassung(workingday);
				

			}

		} else {

			workingday = new Arbeitstag((long) 1, zeiterfassung.getDate());

			// Vormittag Stunden
			workingday.setZeitVormittagEndH(zeiterfassung.getMorningEndHours());
			workingday.setZeitVormittagStartH(zeiterfassung.getMorningstartHours());

			// Vormittag Minuten
			workingday.setZeitVormittagEndMin(zeiterfassung.getMorningEndMinDeci());
			workingday.setZeitVormittagStartMin(zeiterfassung.getMorningStartMinDeci());

			// Summe Vormittag in Dezimal
			workingday.setZeitNachmittagSummeHAndMin(zeiterfassung.getMorningTotal());

			// Nachmittag Stunden
			workingday.setZeitNachmittagEndH(zeiterfassung.getAfternoonEndHours());
			workingday.setZeitNachmittagStartH(zeiterfassung.getAfternoonStartHours());

			// Nachmittag Minuten
			workingday.setZeitNachmittagEndMin(zeiterfassung.getAfternoonEndMinDeci());
			workingday.setZeitNachmittagStartMin(zeiterfassung.getAfternoonStartMinDeci());

			// Summe Nachmittag in Dezimal
			workingday.setZeitNachmittagSummeHAndMin(zeiterfassung.getAfternoonTotal());

			arbeitstagRepository.addZeiterfassung(workingday);
			
		}
		return true;

	}

	// Mitarbeiter Zeiterfassung - Veränderung (BR)

	@PutMapping(path = "/timerecorders/zeiterfassung/changes/", produces = "application/json")
	public boolean zeitveränderung(@RequestBody MessageTimeStamp einstempeln) {

		return true;
	}

	// Mitarbeiter - Ferien erfassen (BR)

	// Mitarbeiter - Zeitplan aufrufen (BR)

	// Mitarbeiter - Monatsrapport aufrufen (BR)

	/*
	 * Mit dieser Methode wird herausgefunden, ob es sich um ein Mitarbeiter oder
	 * Administrator handelt anhand Name (BR)
	 */

//	public String adminORMaListFinder(String name) {
//		boolean isMitarbeiter = true;
//		boolean isAdmin = false;
//		String isMaorAd = "";
//
//		if (isMitarbeiter) {
//			boolean isFound = true;
//
//			if (isFound == true) {
//				Mitarbeiter localMa = mitarbeiterRepository.getSingleMitarbeiterName(name);
//				if (localMa == null) {
//					isMitarbeiter = false;
//					isFound = false;
//				} else {
//					isMaorAd = "Mitarbeiter";
//				}
//
//			} else if (isFound == false) {
//
//				Administrator localAD = administratorenRepository.getSingleAdministratorName(name);
//				if (localAD == null) {
//					isAdmin = false;
//				} else {
//					isMaorAd = "Administrator";
//
//				}
//
//			} else if (isAdmin && isMitarbeiter == false) {
//				logger.warning("Mitarbeiter wurde in beiden Listen nicht gefunden!");
//			}
//
//		}
//
//		return isMaorAd;
//	}

	// Hier wird das Passwort bereits gehasht bevor es abgespeichert wird!
	public String enryptionOfPW(String passwort) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(passwort.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			logger.warning("Passwort Encryption Failure");

		}
		System.out.println(hash.toString());
		return hash.toString();

	}

}
