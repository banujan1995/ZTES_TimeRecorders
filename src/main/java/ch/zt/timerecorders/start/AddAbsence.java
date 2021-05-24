package ch.zt.timerecorders.start;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Kiren Gondal
 *
 */
@Entity
@Table(name = "absencen")
public class AddAbsence {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
		
	public Long mitarbeiterID;	
	public String reason;
	private String period;
	private String anzahlTage;
	

	
	public AddAbsence(Long mitarbeiterID, String reason, String period, String anzahlTage) {
		super();
		this.mitarbeiterID = mitarbeiterID;
		this.reason = reason;
		this.period = period;
		this.anzahlTage = anzahlTage;
	}

	public AddAbsence() {
	
	}

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