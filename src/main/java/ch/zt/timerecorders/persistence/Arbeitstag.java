package ch.zt.timerecorders.persistence;

/**
 * @author Banujan Ragunathan
 */

/*
 * Wir arbeiten mit Dezimalzahl und sobald wir anzeigen wir es umgewandelt auf
 * die Zeit. So ersparen wir uns die Schwierigkeit der Berechnung mit der
 * Zeitformat.
 */

public class Arbeitstag {

	private final Long TAGESID; // Zuordnung mit dem Mitarbeiter oder Administrator
	protected Long mitarbeiterID;

	protected String date;
	protected String time;

	protected int tag;
	protected int monat;
	protected int jahr;

	protected double zeitVormittagStart;
	protected double zeitVormittagEnd;
	protected double zeitVormittagSumme;

	protected double zeitNachmittagStart;
	protected double zeitNachmittagEnd;
	protected double zeitNachmittagSumme;

	protected double überzeit = 0.0;

	public Arbeitstag(Long mitarbeiterID, String date) {
		this.mitarbeiterID = mitarbeiterID;
		this.date = date;

		this.TAGESID = tagesIDGenerator();

		this.zeitVormittagSumme = calculateVormittagZeit(zeitVormittagStart, zeitVormittagEnd);
		this.zeitNachmittagSumme = calculateNachmittagZeit(zeitNachmittagStart, zeitNachmittagEnd);
	}

	// Alle Tageserfassungen erhalten einen Unique TagesID und das kann auch
	// aufgeteilt im Datenbank gespeichert werden.(BR)
	public Long tagesIDGenerator() {
		String localTagesID = this.jahr + this.monat + this.tag + "";
		Long localLongTagesID = Long.parseLong(localTagesID);
		return localLongTagesID;
	}

	public void splittingDateAndTime(String date) {

	}

	public double calculateVormittagZeit(double zeitVormittagStart, double zeitVormittagEnd) {
		double localSumme = zeitVormittagEnd - zeitVormittagStart;
		return localSumme;

	}

	public double calculateNachmittagZeit(double zeitNachmittagStart, double zeitNachmittagEnd) {
		double localSumme = zeitNachmittagEnd - zeitNachmittagStart;
		return localSumme;

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

	public double getZeitVormittagStart() {
		return zeitVormittagStart;
	}

	public void setZeitVormittagStart(double zeitVormittagStart) {
		this.zeitVormittagStart = zeitVormittagStart;
	}

	public double getZeitVormittagEnd() {
		return zeitVormittagEnd;
	}

	public void setZeitVormittagEnd(double zeitVormittagEnd) {
		this.zeitVormittagEnd = zeitVormittagEnd;
	}

	public double getZeitNachmittagStart() {
		return zeitNachmittagStart;
	}

	public void setZeitNachmittagStart(double zeitNachmittagStart) {
		this.zeitNachmittagStart = zeitNachmittagStart;
	}

	public double getZeitNachmittagEnd() {
		return zeitNachmittagEnd;
	}

	public void setZeitNachmittagEnd(double zeitNachmittagEnd) {
		this.zeitNachmittagEnd = zeitNachmittagEnd;
	}

	public Long getTAGESID() {
		return TAGESID;
	}

	public double getZeitVormittagSumme() {
		return zeitVormittagSumme;
	}

	public double getZeitNachmittagSumme() {
		return zeitNachmittagSumme;
	}

	public void mehrOderWenigerÜberzeit(double plusOderMinusZeit) {
		this.überzeit += plusOderMinusZeit;
	}

	public double getÜberzeit() {
		return überzeit;
	}

}
