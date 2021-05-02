package ch.zt.timerecorders.businesslogic;

/**
 * @author Banujan Ragunathan
 */

public class Administrator {
	

	public int id = 0;
	public String administratorID;
	public String name;
	public String vorname;

	public Administrator(String vorname, String name) {
		this.vorname = vorname;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdministratorID() {
		return administratorID;
	}

	public void setAdministratorID(String administratorID) {
		this.administratorID = administratorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	

}
