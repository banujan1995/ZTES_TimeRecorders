package ch.zt.timerecorders.services;

import java.util.Date;

/**
 * 
 * @author Kiren Gondal
 *
 */

public class MessageMaRegister {
	
	private Long mitarbeiterId;
	
	public String surname;
	public String familyname;
	public String username;
	public String passwort;
	public String pensum;
	public String role; 

	
	public Long getMitarbeiterId() {
		return mitarbeiterId;
	}

	public void setMitarbeiterId(Long mitarbeiterId) {
		this.mitarbeiterId = mitarbeiterId;
	}

	public String getUserame() {
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

	public String getUsername() {
		return username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
