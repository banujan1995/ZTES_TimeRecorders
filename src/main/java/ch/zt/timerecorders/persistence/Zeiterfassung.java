package ch.zt.timerecorders.persistence;

/**
 * @author Banujan Ragunathan
 */

/*
 * Wir arbeiten mit Dezimalzahl und sobald wir anzeigen wir es umgewandelt auf
 * die Zeit. So ersparen wir uns die Schwierigkeit der Berechnung mit der
 * Zeitformat.
 */

public class Zeiterfassung {

	private final String TAGESID; // Zuordnung mit dem Mitarbeiter oder Administrator

	public int tag;
	public int monat;
	public int jahr;

	public double zeitStart;
	public double zeitEnd;
	public double zeitSumme;

	public Zeiterfassung(int tag, int monat, int jahr, double zeitStart, double zeitEnd, double zeitSumme) {
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;

		this.zeitStart = zeitStart;
		this.zeitEnd = zeitEnd;
		this.zeitSumme = zeitSumme;
		
		this.TAGESID = tagesIDGenerator(); 
		
		
	}
	
	//Alle Tageserfassungen erhalten einen Unique TagesID und das kann auch aufgeteilt im Datenbank gespeichert werden.(BR)
	public String tagesIDGenerator(){
		String localTagesID = this.jahr + this.monat + this.tag + ""; 
		System.out.println(localTagesID); 
		return localTagesID;
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

	public double getZeitStart() {
		return zeitStart;
	}

	public void setZeitStart(float zeitStart) {
		this.zeitStart = zeitStart;
	}

	public double getZeitEnd() {
		return zeitEnd;
	}

	public void setZeitEnd(float zeitEnd) {
		this.zeitEnd = zeitEnd;
	}

	public double getZeitSumme() {
		return zeitSumme;
	}

	public void setZeitSumme(float zeitSumme) {
		this.zeitSumme = zeitSumme;
	}

	public String getADODERMAID() {
		return TAGESID;
	}

}
