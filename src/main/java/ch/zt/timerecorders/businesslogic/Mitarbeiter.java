package ch.zt.timerecorders.businesslogic;

/**
 * 
 * @author Banujan Ragunathan
 *
 */

public class Mitarbeiter {

	public int id = 0;
	public String mitarbeiterID;
	public String name;
	public String vorname;

	public Mitarbeiter(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}
	
	public int getId() {
		return id;
	}

	public String getMitarbeiterID() {
		return mitarbeiterID;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setIntMitarbeiterID(int id) {
		this.id = id;
	}

	public void setMitarbeiterName(String name) {
		this.name = name;
	}

	public void setMitarbeiterVorname(String vorname) {
		this.vorname = vorname;
	}

	public void setMitarbeiterID(String mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}

}
