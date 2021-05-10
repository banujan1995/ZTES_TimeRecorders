package ch.zt.timerecorders.start;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */
@Entity
public class Mitarbeiter {

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long mitarbeiterID;
	
	public String name;
	
	public String vorname;

	public Mitarbeiter(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}
	

	public Mitarbeiter() {
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
