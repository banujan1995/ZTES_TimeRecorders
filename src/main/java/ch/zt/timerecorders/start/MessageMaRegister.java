package ch.zt.timerecorders.start;

import java.util.Date;

public class MessageMaRegister {
	
	private Long mitarbeiterId;
	
	public String surname;
	public String familyname;
	public String username;
	public String passwort;
	public String pensum;

	
	public Long getMitarbeiterId() {
		return mitarbeiterId;
	}

	public void setMitarbeiterId(Long mitarbeiterId) {
		this.mitarbeiterId = mitarbeiterId;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getPensum() {
		return pensum;
	}

	public void setPensum(String pensum) {
		this.pensum = pensum;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	
	
	
	


}
