package ch.zt.timerecorders.persistence;

/**
 * 
 * @author Kiren Gondal
 * @author Banujan Ragunathan
 *
 */

public class MessageAddAbsence {

	
	protected Long mitarbeiterID;
	protected String username;
	protected String grund;
	protected String period;
	protected String anzahlTage;
	
	
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
