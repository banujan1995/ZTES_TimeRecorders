package ch.zt.timerecorders.services;

/**
 * 
 * @author Kiren Gondal
 *
 */

public class MessageAddAbsence {

	
	public Long mitarbeiterID;	
	public String reason;
	private String period;
	private String anzahlTage;
	
	
	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}
	public void setMitarbeiterID(Long mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
