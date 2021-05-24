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
import ch.zt.timerecorders.start.AddAbsence;
import ch.zt.timerecorders.start.AddAbsenceRepositoryInterface;
import ch.zt.timerecorders.start.MitarbeiterRegister;
import ch.zt.timerecorders.start.MitarbeiterRepositoryInterface;
import ch.zt.timerecorders.start.ServiceLocator;
import ch.zt.timerecorders.start.TimeStampRegisterChange;
import ch.zt.timerecorders.start.TimeStampRegisterChangeInterface;

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

	@Autowired
	private TimeStampRegisterChangeInterface timeStampRegisterChange;

	
	@Autowired
	private AddAbsenceRepositoryInterface absenceRepo;
	/*
	 * Instanzvariablen für die TagesIDCreator
	 */
	protected int tag;
	protected int monat;
	protected int jahr;

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
	
	// KG: Change Password eines Benutzers ändern
			@PostMapping(path = "/changePassword/", produces = "application/json")
			public boolean changePasswort(@RequestBody MessageMaRegister m) {
				
				List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();
				
				for (MitarbeiterRegister ml : ma) {
					if (m.getUsername().equals(ml.getUsername())) {
						ml.setPasswort(m.getPasswort());
						ml = mitarbeiterRepositoryInterface.save(ml);
						logger.info("Passwort wurde geändert!");
						return true;
					} else {
						logger.info("Mitarbeiter nicht vorhanden");

					}

				}
				return false;
			}
			
			//Liste der erfassten Ferien als JSON (KG) 
			@ResponseBody
			@GetMapping(path = "/erfassteFerien/", produces = "application/json")
			public List addedAbsence() {
				List<AddAbsence> absence = absenceRepo.findAll();
				logger.info(absence.toString() + "Erfasste Ferien werden übergeben");
				return absence;

			}
			
			//Ferien erfassen (KG)
			@PostMapping(path = "/addAbsence/", produces = "application/json")
			public boolean addAbsence(@RequestBody MessageAddAbsence a) {

				AddAbsence a1 = new AddAbsence();
				a1.setPeriod(a.getPeriod());
				a1.setReason(a.getReason());
				a1.setAnzahlTage(a.getAnzahlTage());		

				absenceRepo.save(a1); // beim Speichern wird eine ID automatisch vergeben
				logger.info("Ferien erfolgreich erfasst");
				return true;

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
			if ((m.getUsername().equals(login.getUsername()) && (m.getPasswort().equals(login.getPasswort())))) {
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

	// Hier wird die Liste geholt aus dem Datenbank und wird als Json angezeigt. (BR)
	@ResponseBody
	@GetMapping(path = "/timerecorders/timestamps/", produces = "application/json")
	public List allTimeStamps() {
		List<TimeStampRegisterChange> time = timeStampRegisterChange.findAll();
		logger.info(time.toString() + "TimeStamps wurden übergeben");
		return time;

	}

	@PostMapping(path = "/timerecorders/zeiterfassung/", produces = "application/json")
	public boolean zeitenInServer(@RequestBody MessageTimeStamp zeiterfassung) {

		List<TimeStampRegisterChange> timeStamps = timeStampRegisterChange.findAll();

		TimeStampRegisterChange timeStamp;

		String localDate;

		boolean zeiterfassungGefunden = false;

		if (timeStamps.size() != 0) {

			for (counterY = 0; counterY < timeStamps.size(); counterY++) {
				localDate = "" + timeStamps.get(counterY).getTAGESID();

				if (localDate.equalsIgnoreCase(tagesIDGenerator(zeiterfassung.getDate()) + "")) {
					zeiterfassungGefunden = true;
					break;

				} else {
					zeiterfassungGefunden = false;

				}

			}

			if (zeiterfassungGefunden) {
				
				//Datum
				timeStamps.get(counterY).setDate(zeiterfassung.getDate());
				
				// Vormittag Stunden
								
				timeStamps.get(counterY).setMorningEndHours(zeiterfassung.getMorningEndHours());
				timeStamps.get(counterY).setMorningstartHours(zeiterfassung.getMorningstartHours());

				// Vormittag Minuten
				timeStamps.get(counterY).setMorningEndMinDeci(zeiterfassung.getMorningEndMinDeci());
				timeStamps.get(counterY).setMorningStartMinDeci(zeiterfassung.getMorningStartMinDeci());

				// Summe Vormittag in Dezimal
				timeStamps.get(counterY).setMorningTotal(zeiterfassung.getMorningTotal());

				// Nachmittag Stunden
				timeStamps.get(counterY).setAfternoonEndHours(zeiterfassung.getAfternoonEndHours());
				timeStamps.get(counterY).setAfternoonStartHours(zeiterfassung.getAfternoonStartHours());

				// Nachmittag Minuten
				timeStamps.get(counterY).setAfternoonEndMinDeci(zeiterfassung.getAfternoonEndMinDeci());
				timeStamps.get(counterY).setAfternoonStartMinDeci(zeiterfassung.getAfternoonStartMinDeci());

				// Summe Nachmittag in Dezimal
				timeStamps.get(counterY).setAfternoonTotal(zeiterfassung.getAfternoonTotal());
				
				//Summe ganzer Tag 
				timeStamps.get(counterY).setTotalDeci(zeiterfassung.getTotalDeci());

				timeStamps = timeStampRegisterChange.saveAll(timeStamps);

			} else if (!zeiterfassungGefunden) {
				// workingday = new Arbeitstag((long) 1, zeiterfassung.getDate());
				timeStamp = new TimeStampRegisterChange();

				timeStamp.setTAGESID(tagesIDGenerator(zeiterfassung.getDate()));
				timeStamp.setDate(zeiterfassung.getDate());
//				timeStamp.setMitarbeiterID(101);

				// Vormittag Stunden
				timeStamp.setMorningEndHours(zeiterfassung.getMorningEndHours());
				timeStamp.setMorningstartHours(zeiterfassung.getMorningstartHours());

				// Vormittag Minuten
				timeStamp.setMorningEndMinDeci(zeiterfassung.getMorningEndMinDeci());
				timeStamp.setMorningStartMinDeci(zeiterfassung.getMorningStartMinDeci());

				// Summe Vormittag in Dezimal
				timeStamp.setMorningTotal(zeiterfassung.getMorningTotal());

				// Nachmittag Stunden
				timeStamp.setAfternoonEndHours(zeiterfassung.getAfternoonEndHours());
				timeStamp.setAfternoonStartHours(zeiterfassung.getAfternoonStartHours());

				// Nachmittag Minuten
				timeStamp.setAfternoonEndMinDeci(zeiterfassung.getAfternoonEndMinDeci());
				timeStamp.setAfternoonStartMinDeci(zeiterfassung.getAfternoonStartMinDeci());

				// Summe Nachmittag in Dezimal
				timeStamp.setAfternoonTotal(zeiterfassung.getAfternoonTotal());
				
				//Summe ganzer Tag 
				timeStamp.setTotalDeci(zeiterfassung.getTotalDeci());

				// Summe Überzeit
				timeStamp.setMinusOderPlusZeit(0.00);

				timeStamp = timeStampRegisterChange.save(timeStamp); // Speichert den Datensatz in den Datenbank (BR)
				logger.info("Daten in Datenbank gespeichert - Klasse Mitarbeiterservice");

			}

		} else {
			timeStamp = new TimeStampRegisterChange();

			timeStamp.setTAGESID(tagesIDGenerator(zeiterfassung.getDate()));
			timeStamp.setDate(zeiterfassung.getDate());

			// Vormittag Stunden
			timeStamp.setMorningEndHours(zeiterfassung.getMorningEndHours());
			timeStamp.setMorningstartHours(zeiterfassung.getMorningstartHours());

			// Vormittag Minuten
			timeStamp.setMorningEndMinDeci(zeiterfassung.getMorningEndMinDeci());
			timeStamp.setMorningStartMinDeci(zeiterfassung.getMorningStartMinDeci());

			// Summe Vormittag in Dezimal
			timeStamp.setMorningTotal(zeiterfassung.getMorningTotal());

			// Nachmittag Stunden
			timeStamp.setAfternoonEndHours(zeiterfassung.getAfternoonEndHours());
			timeStamp.setAfternoonStartHours(zeiterfassung.getAfternoonStartHours());

			// Nachmittag Minuten
			timeStamp.setAfternoonEndMinDeci(zeiterfassung.getAfternoonEndMinDeci());
			timeStamp.setAfternoonStartMinDeci(zeiterfassung.getAfternoonStartMinDeci());

			// Summe Nachmittag in Dezimal
			timeStamp.setAfternoonTotal(zeiterfassung.getAfternoonTotal());
			
			//Summe ganzer Tag 
			timeStamp.setTotalDeci(zeiterfassung.getTotalDeci());

			// Summe Überzeit
			timeStamp.setMinusOderPlusZeit(0.00);

			timeStamp = timeStampRegisterChange.save(timeStamp); // Speichert den Datensatz in den Datenbank (BR)
			logger.info("Daten in Datenbank gespeichert - Klasse Mitarbeiterservice");
		}
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

	/*
	 * Hier wird der Input von dem Webapplikation aufgeteilt und ein TagesID
	 * kreiert.
	 */

	// Alle Tageserfassungen erhalten einen Unique TagesID und das kann auch
	// aufgeteilt im Datenbank gespeichert werden.(BR)
	public int tagesIDGenerator(String date) {
		splittingDateAndTime(date);

		String localTagesID = "" + this.jahr + this.monat + this.tag;
		Integer localLongTagesID = Integer.parseInt(localTagesID);
		return localLongTagesID;
	}

	// Format of the Data: Mon May 17 2021
	public void splittingDateAndTime(String date) {

		// Monat
		String localmonat = date.substring(4, 7);

		switch (localmonat) {

		case "Jan":
			this.monat = 1;
			break;

		case "Feb":
			this.monat = 2;
			break;

		case "Mar":
			this.monat = 3;
			break;

		case "Apr":
			this.monat = 4;
			break;

		case "May":
			this.monat = 5;
			break;

		case "Jun":
			this.monat = 6;
			break;

		case "Jul":
			this.monat = 7;
			break;

		case "Aug":
			this.monat = 8;
			break;

		case "Sep":
			this.monat = 9;
			break;

		case "Oct":
			this.monat = 10;
			break;

		case "Nov":
			this.monat = 11;
			break;

		case "Dec":
			this.monat = 12;
			break;

		default:

		}

		// Tag
		String localTag = date.substring(8, 10);
		this.tag = Integer.parseInt(localTag);

		// Jahr
		String localJahr = date.substring(11, 15);
		this.jahr = Integer.parseInt(localJahr);

	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getMonat() {
		return monat;
	}

	public void setMonat(int monat) {
		this.monat = monat;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

}
