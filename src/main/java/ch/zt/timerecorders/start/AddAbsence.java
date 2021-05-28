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
	public String grund;
	private String period;
	private String anzahlTage;
	

	
	public AddAbsence(Long mitarbeiterID, String grund, String period, String anzahlTage) {
		super();
		this.mitarbeiterID = mitarbeiterID;
		this.grund = grund;
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