package ch.zt.timerecorders.businesslogic;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */
@Table(value = "mitarbeiter")
public class Mitarbeiter {

	@Id
	public Long mitarbeiterID;
	
	@Column(value = "name")
	public String name;
	
	@Column(value = "vorname")
	public String vorname;

	public Mitarbeiter(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
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
