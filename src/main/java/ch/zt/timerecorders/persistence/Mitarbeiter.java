package ch.zt.timerecorders.persistence;

import org.springframework.beans.factory.annotation.Autowired;

import ch.zt.timerecorders.businesslogic.Pensum;
import ch.zt.timerecorders.start.ServiceLocator;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */
public class Mitarbeiter {
	
	public Long mitarbeiterID;
	public String name;
	public String vorname;
	public String passwort; 
	public Pensum pensum; 

	
	public Mitarbeiter(String name, String vorname, Pensum pensum) {
		this.name = name;
		this.vorname = vorname;
		this.pensum = pensum; 
	}

	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setIntMitarbeiterID(Long string) {
		this.mitarbeiterID = string;
	}

	public void setMitarbeiterName(String name) {
		this.name = name;
	}

	public void setMitarbeiterVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setMitarbeiterID(Long string) {
		this.mitarbeiterID = string;
	}

}
