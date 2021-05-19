package ch.zt.timerecorders.persistence;

import java.util.logging.Logger;

import ch.zt.timerecorders.start.ServiceLocator;

/**
 * @author Banujan Ragunathan
 */

/*
 * Wir arbeiten mit Dezimalzahl und sobald wir anzeigen wir es umgewandelt auf
 * die Zeit. So ersparen wir uns die Schwierigkeit der Berechnung mit der
 * Zeitformat.
 */

public class Arbeitstag {
	Logger logger = ServiceLocator.getServiceLocator().getLogger();

	private final Long TAGESID; // Zuordnung mit dem Mitarbeiter oder Administrator
	protected Long mitarbeiterID;

	protected String date;

	protected int tag;
	protected int monat;
	protected int jahr;

	// Stunden Vormittag
	protected int zeitVormittagStartH;
	protected int zeitVormittagEndH;

	// Minuten Vormittag
	protected double zeitVormittagStartMin;
	protected double zeitVormittagEndMin;

	// Summe Vormittag in Dezimal
	protected double zeitVormittagSummeHAndMin;

	// Stunden Nachmittag
	protected int zeitNachmittagStartH;
	protected int zeitNachmittagEndH;

	// Minuten Nachmittag
	protected double zeitNachmittagStartMin;
	protected double zeitNachmittagEndMin;

	// Summe Nachmittag in Dezimal
	protected double zeitNachmittagSummeHAndMin;

	protected double überzeit = 0.0;

	public Arbeitstag(Long mitarbeiterID, String date) {
		this.mitarbeiterID = mitarbeiterID;
		this.date = date;
		splittingDateAndTime(date);
		this.TAGESID = tagesIDGenerator();

	}

	// Alle Tageserfassungen erhalten einen Unique TagesID und das kann auch
	// aufgeteilt im Datenbank gespeichert werden.(BR)
	public Long tagesIDGenerator() {
		String localTagesID = "" + this.jahr + this.monat + this.tag;
		Long localLongTagesID = Long.parseLong(localTagesID);
		return localLongTagesID;
	}

	// Format of the Data: Mon May 17 2021
	public void splittingDateAndTime(String date) {
		logger.info("Die Daten von Datum " +date+ " wurden auf dem Datenbank gespeichert.");
		
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
			logger.info("Der Monatswert ist kein gültiger Wert - Fehler");

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

	public Long getTAGESID() {
		return TAGESID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getZeitVormittagStartH() {
		return zeitVormittagStartH;
	}

	public void setZeitVormittagStartH(int zeitVormittagStartH) {
		this.zeitVormittagStartH = zeitVormittagStartH;
	}

	public int getZeitVormittagEndH() {
		return zeitVormittagEndH;
	}

	public void setZeitVormittagEndH(int zeitVormittagEndH) {
		this.zeitVormittagEndH = zeitVormittagEndH;
	}

	public double getZeitVormittagStartMin() {
		return zeitVormittagStartMin;
	}

	public void setZeitVormittagStartMin(double zeitVormittagStartMin) {
		this.zeitVormittagStartMin = zeitVormittagStartMin;
	}

	public double getZeitVormittagEndMin() {
		return zeitVormittagEndMin;
	}

	public void setZeitVormittagEndMin(double zeitVormittagEndMin) {
		this.zeitVormittagEndMin = zeitVormittagEndMin;
	}

	public double getZeitVormittagSummeHAndMin() {
		return zeitVormittagSummeHAndMin;
	}

	public void setZeitVormittagSummeHAndMin(double zeitVormittagSummeHAndMin) {
		this.zeitVormittagSummeHAndMin = zeitVormittagSummeHAndMin;
	}

	public int getZeitNachmittagStartH() {
		return zeitNachmittagStartH;
	}

	public void setZeitNachmittagStartH(int zeitNachmittagStartH) {
		this.zeitNachmittagStartH = zeitNachmittagStartH;
	}

	public int getZeitNachmittagEndH() {
		return zeitNachmittagEndH;
	}

	public void setZeitNachmittagEndH(int zeitNachmittagEndH) {
		this.zeitNachmittagEndH = zeitNachmittagEndH;
	}

	public double getZeitNachmittagStartMin() {
		return zeitNachmittagStartMin;
	}

	public void setZeitNachmittagStartMin(double zeitNachmittagStartMin) {
		this.zeitNachmittagStartMin = zeitNachmittagStartMin;
	}

	public double getZeitNachmittagEndMin() {
		return zeitNachmittagEndMin;
	}

	public void setZeitNachmittagEndMin(double zeitNachmittagEndMin) {
		this.zeitNachmittagEndMin = zeitNachmittagEndMin;
	}

	public double getZeitNachmittagSummeHAndMin() {
		return zeitNachmittagSummeHAndMin;
	}

	public void setZeitNachmittagSummeHAndMin(double zeitNachmittagSummeHAndMin) {
		this.zeitNachmittagSummeHAndMin = zeitNachmittagSummeHAndMin;
	}

	public void mehrOderWenigerÜberzeit(double plusOderMinusZeit) {
		this.überzeit += plusOderMinusZeit;
	}

	public double getÜberzeit() {
		return überzeit;
	}

}
