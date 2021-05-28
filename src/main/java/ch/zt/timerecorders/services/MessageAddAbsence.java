package ch.zt.timerecorders.services;

/**
 * 
 * @author Kiren Gondal
 *
 */

public class MessageAddAbsence {

	
	public Long mitarbeiterID;	
	public String grund;
	private String period;
	private String anzahlTage;
	
	
	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}
	public void setMitarbeiterID(Long mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}
	
	public String getGrund() {
		return grund;
	}
	public void setGrund(String grund) {
		this.grund = grund;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getAnzahlTage() {
		return anzahlTage;
	}
	public void setAnzahlTage(String anzahlTage) {
		this.anzahlTage = anzahlTage;
	}
	
	
}
