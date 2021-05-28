package ch.zt.timerecorders.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

import ch.zt.timerecorders.persistence.MessageAddAbsence;
import ch.zt.timerecorders.persistence.MessageMaRegister;
import ch.zt.timerecorders.persistence.MessageTimeStamp;
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

/*
 * Hier werden alle Service betreffend dem Mitarbeiter angeboten. Diese werden
 * über den Pfad von der Webapplikation geholt und bei einer Funktion verwendet.
 * (BR/KG)
 */

@RestController
public class MitarbeiterService {

	Logger logger = ServiceLocator.getServiceLocator().getLogger();

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

	private int counterY = 0;

	/**
	 * CRUD Methoden, um Mitarbeiter zu erfassen, mutieren, verändern, löschen (BR)
	 */

	// Mitarbeiter erstellen (KG)

	@PostMapping(path = "/addEmployee/", produces = "application/json")
	public long createNewMa(@RequestBody MessageMaRegister m) {

		MitarbeiterRegister m1 = new MitarbeiterRegister();
		m1.setSurname(m.getSurname());
		m1.setFamilyname(m.getFamilyname());
		m1.setName(m.getUsername());
		m1.setPasswort(m.getPasswort());
		m1.setPensum(m.getPensum().substring(0, 3));
		m1.setRole(m.getRole());
		m1.setWorkingDays(m.getWorkingDays());

		m1 = mitarbeiterRepositoryInterface.save(m1); // beim Speichern wird eine MAId automatisch vergeben
		logger.info("Mitarbeiter mit oder ohne Adminfunktion erfolgreich hinzugefügt");
		return m1.getMitarbeiterID();

	}

	// MA Liste erstellen als JSON (KG)
	@ResponseBody
	@GetMapping(path = "/mitarbeiterList/", produces = "application/json")
	public List allMA() {

		List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();
		logger.info(ma.toString() + "Liste wurde erfolgreich erstellt");
		return ma;

	}

	// Change Username (KG)
	@PostMapping(path = "/changeUsername/", produces = "application/json")
	public boolean changeUsername(@RequestBody MessageMaRegister m) {

		List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();

		for (MitarbeiterRegister ml : ma) {
			if (ml.getUsername().equals(m.getUserame())) {
				ml.setName(m.getSurname());
				ml = mitarbeiterRepositoryInterface.save(ml);
				logger.info("Benutzername wurde geändert!");
				return true;
			} else {
				logger.info("Benutzername nicht vorhanden");

			}

		}
		return false;
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
				logger.info("Passwort wurde nicht geändert!");

			}

		}
		return false;
	}

	/**
	 * Allgemeine internen Funktionen Funktionen für Mitarbeiter, welche von
	 * Webapplikation aufgeruft werden auf dem Webapplikation (BR)
	 */

	/*
	 * Dieser Service wird verwendet, damit sich der Mitarbeiter oder Administrator
	 * einloggen. (KG)
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

	// Liste der erfassten Ferien als JSON (KG)
	@ResponseBody
	@GetMapping(path = "/erfassteFerien/", produces = "application/json")
	public List addedAbsence() {
		List<AddAbsence> absence = absenceRepo.findAll();
		logger.info("Die Liste mit der Absenzen wurde geholt!");
		return absence;

	}

	// Ferien erfassen (KG)
	@PostMapping(path = "/addAbsence/", produces = "application/json")
	public boolean addAbsence(@RequestBody MessageAddAbsence a) {

		AddAbsence a1 = new AddAbsence();
		a1.setPeriod(a.getPeriod());
		a1.setAnzahlTage(a.getAnzahlTage());
		a1.setGrund(a.getGrund());
		a1.setUsername(a.getUsername());

		absenceRepo.save(a1); // beim Speichern wird eine ID automatisch vergeben
		logger.info("Ferien erfolgreich erfasst");
		return true;

	}

	/*
	 * Hier wird die Liste geholt aus dem Datenbank und wird als Json angezeigt.
	 * Hier wird auch die Absence erfasst! (BR)
	 */
	@ResponseBody
	@GetMapping(path = "/timerecorders/timestamps/", produces = "application/json")
	public List allTimeStamps() {
		List<TimeStampRegisterChange> time = timeStampRegisterChange.findAll();
		logger.info("TimeStamps wurden übergeben");
		return time;

	}

	/*
	 * Hier wird die komplexe Methode Daten von der Webapplikation im Datenbank
	 * speichern. (BR) Dabei wird beachtet, ob die Liste leer ist oder ob die die
	 * Erfassung bereits gibt oder nicht.
	 */

	@PostMapping(path = "/timerecorders/zeiterfassung/", produces = "application/json")
	public boolean zeitenInServer(@RequestBody MessageTimeStamp zeiterfassung) {

		List<TimeStampRegisterChange> timeStamps = timeStampRegisterChange.findAll();

		TimeStampRegisterChange timeStamp;

		String localDate;

		boolean zeiterfassungGefunden = false;
		int foundPlace = 0;

		for (counterY = 0; counterY < timeStamps.size(); counterY++) {
			localDate = "" + timeStamps.get(counterY).getTAGESID();

			if (localDate.equalsIgnoreCase(tagesIDGenerator(zeiterfassung.getDate()) + "")) {
				zeiterfassungGefunden = true;
				foundPlace = counterY;
				break;

			} else {
				zeiterfassungGefunden = false;

			}
		}

		try {

		if (zeiterfassungGefunden) {

			// Username
			timeStamps.get(foundPlace).setUsername(zeiterfassung.getUsername());

			// Pensum
			timeStamps.get(foundPlace).setPensum(getMitarbeiterPensum(zeiterfassung.getUsername()));

			// Targettime
			timeStamps.get(foundPlace)
					.setTargettime(getTargetTimeDay(zeiterfassung.getUsername(), zeiterfassung.getDate()));

			// Datum
			timeStamps.get(foundPlace).setDate(zeiterfassung.getDate());

			// Hier wird der Grund direkt gesetzt.
			timeStamps.get(foundPlace).setGrund(zeiterfassung.getGrund());

			// Vormittag Stunden

			timeStamps.get(foundPlace).setMorningEndHours(zeiterfassung.getMorningEndHours());
			timeStamps.get(foundPlace).setMorningstartHours(zeiterfassung.getMorningstartHours());

			// Vormittag Minuten
			timeStamps.get(foundPlace).setMorningEndMinDeci(zeiterfassung.getMorningEndMinDeci());
			timeStamps.get(foundPlace).setMorningStartMinDeci(zeiterfassung.getMorningStartMinDeci());

			// Summe Vormittag in Dezimal
			timeStamps.get(foundPlace).setMorningTotal(zeiterfassung.getMorningTotal());

			// Nachmittag Stunden
			timeStamps.get(foundPlace).setAfternoonEndHours(zeiterfassung.getAfternoonEndHours());
			timeStamps.get(foundPlace).setAfternoonStartHours(zeiterfassung.getAfternoonStartHours());

			// Nachmittag Minuten
			timeStamps.get(foundPlace).setAfternoonEndMinDeci(zeiterfassung.getAfternoonEndMinDeci());
			timeStamps.get(foundPlace).setAfternoonStartMinDeci(zeiterfassung.getAfternoonStartMinDeci());

			// Summe Nachmittag in Dezimal
			timeStamps.get(foundPlace).setAfternoonTotal(zeiterfassung.getAfternoonTotal());

			// Summe ganzer Tag
			timeStamps.get(foundPlace).setTotalDeci(zeiterfassung.getTotalDeci());

			// Summe Überzeit
			timeStamps.get(foundPlace).setMinusOderPlusZeit(überzeitRechner(zeiterfassung.getTotalDeci()));

			timeStamps = timeStampRegisterChange.saveAll(timeStamps);
			timeStampRegisterChange.flush();

		} else if (!zeiterfassungGefunden || timeStamps.size() == 0) {
			// workingday = new Arbeitstag((long) 1, zeiterfassung.getDate());
			timeStamp = new TimeStampRegisterChange();

			// Username
			timeStamp.setUsername(zeiterfassung.getUsername());

			// Pensum
			timeStamp.setPensum(getMitarbeiterPensum(zeiterfassung.getUsername()));

			// Targettime
			timeStamp.setTargettime(getTargetTimeDay(zeiterfassung.getUsername(), zeiterfassung.getDate()));

			// TagesID setzen
			timeStamp.setTAGESID(tagesIDGenerator(zeiterfassung.getDate()));

			// Datum setzen
			timeStamp.setDate(zeiterfassung.getDate());

			timeStamp.setGrund(zeiterfassung.getGrund()); // Hier wird der Grund direkt gesetzt.

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

			// Summe ganzer Tag
			timeStamp.setTotalDeci(zeiterfassung.getTotalDeci());

			// Summe Überzeit
			timeStamp.setMinusOderPlusZeit(überzeitRechner(zeiterfassung.getTotalDeci()));

			timeStamp = timeStampRegisterChange.save(timeStamp); // Speichert den Datensatz in den Datenbank (BR)
			timeStampRegisterChange.flush();
			logger.info("Daten in Datenbank gespeichert!");

		}}catch (Exception e) {
			logger.info(e.toString());
		}
		return true;

	}

	/*
	 * Hier wird die Summe der Differenz zwischen Sollzeit und Istzeit gerechnet und
	 * ausgewiesen. Dient rein als Hilfeklasse bei der Abspeicherung der Daten von
	 * der Webapplikation in die Datenbank. (BR)
	 */

	public double überzeitRechner(double totalDeci) {
		double überzeit = 0.0;
		double tagessatz = 8.4;

		if (totalDeci >= 0) {
			überzeit = totalDeci - tagessatz;

		} else if (totalDeci < 0) {
			überzeit = tagessatz - totalDeci;

		}

		return überzeit;

	}

	/*
	 * Dies ist eine Allgemeinservice, welche die erwartete Arbeitszeit am Tag holt.
	 * Es wird serverseiting und clientseitig (doppelt) gemacht, um Sicherheit der
	 * Rechnung stellen. Dient als Hilfefunktion für die Speicherung der Daten von
	 * der Webapplikation in die Datenbank. (BR)
	 */

	public double getTargetTimeDay(String username, String date) {
		String monday = "";
		String tuesday = "";
		String wednesday = "";
		String thursday = "";
		String friday = "";

		double targettimeDay = 8.4;
		String workingDays;

		List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();

		for (MitarbeiterRegister ml : ma) {
			if (ml.getUsername().equalsIgnoreCase(username)) {

				workingDays = ml.getWorkingDays();

				// https://www.geeksforgeeks.org/split-string-java-examples/
				String[] arrOfStr = workingDays.split(",");

				for (String a : arrOfStr) {

					switch (a) {
					case "Monday":
						monday = "Mon";
						break;
					case "Tuesday":
						tuesday = "Tue";
						break;
					case "Wednesday":
						wednesday = "Wed";
						break;
					case "Thursday":
						thursday = "Thu";
						break;
					case "Friday":
						friday = "Fri";
						break;
					default:
						logger.info("Methode: Switch in Default");
					}

				}

				logger.info("Arbeitstage des Mitarbeiters gefunden.");

			} else {
				logger.info("Arbeitstage des Mitarbeiters nicht gefunden.");
			}

		}
		if (date.substring(0, 3).equalsIgnoreCase(monday)) {
			return targettimeDay;
		} else if (date.substring(0, 3).equalsIgnoreCase(tuesday)) {
			return targettimeDay;
		} else if (date.substring(0, 3).equalsIgnoreCase(wednesday)) {
			return targettimeDay;
		} else if (date.substring(0, 3).equalsIgnoreCase(thursday)) {
			return targettimeDay;
		} else if (date.substring(0, 3).equalsIgnoreCase(friday)) {
			return targettimeDay;
		} else {
			return 0.0;
		}

	}

	/*
	 * Hier wird die Mitarbeiterliste durchgegangen und der Pensum rausgeholt, um es
	 * mit den Zeiterfassung zu speichern. (BR) Dient als Hilfefunktion für die
	 * Speicherung der Daten von der Webapplikation in die Datenbank. (BR)
	 */
	public int getMitarbeiterPensum(String username) {
		logger.info("Suchfunktion nach Pensum");

		int pensum = 0;
		List<MitarbeiterRegister> ma = mitarbeiterRepositoryInterface.findAll();

		for (MitarbeiterRegister ml : ma) {
			if (ml.getUsername().equalsIgnoreCase(username)) {

				pensum = Integer.parseInt(ml.getPensum());
				logger.info("Rolle des Mitarbeiters und dazugehörigen Pensum " + username + " " + pensum);
				break;

			} else {

				logger.info("Pensum des Mitarbeiters nicht gefunden.");
			}

		}
		return pensum;
	}

	/*
	 * Alle Tageserfassungen erhalten einen UniqueTagesID und so können die Tage
	 * korrekt im Datenbank gespeichert werden und später referenziert werden. Dient
	 * als Hilfefunktion für die Speicherung der Daten von der Webapplikation in die
	 * Datenbank. (BR)
	 */

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

	// Hier sind die Getter und Setter für die Methode: splittingDateAndTime (BR)

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
