package ch.zt.timerecorders.start;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */


/*
 * Folgende Information werden im Datenbank gespeichert, welche von jeder HTML
 * Seite abgerufen.
 */

@Entity
@Table(name = "mitarbeiter")
public class MitarbeiterRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

//	@OneToOne(mappedBy = "mitarbeiter", fetch = FetchType.LAZY,
//    cascade = CascadeType.ALL)
	public Long mitarbeiterID;

	public String familyname;
	public String surname;

	@Column(name = "username", unique = true, nullable = false)
	public String username;

	public String passwort;
	public String pensum;

	public String role;

	public String workingDays;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MitarbeiterRegister> mitarbeiter = new ArrayList<>();

	public MitarbeiterRegister(Long mitarbeiterID, String surname, String familyname, String username, String passwort,
			String pensum, String role, String workingDays) {
		super();
		this.mitarbeiterID = mitarbeiterID;
		this.surname = surname;
		this.familyname = familyname;
		this.username = username;
		this.passwort = passwort;
		this.pensum = pensum;
		this.role = role;
		this.workingDays = workingDays;
	}

	public String getPensum() {
		return pensum;
	}

	public void setPensum(String string) {
		this.pensum = string;
	}

	// noch nicht löschen - Kiren
	public MitarbeiterRegister() {
	}

	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}

	public String getUsername() {
		return username;
	}

	public void setIntMitarbeiterID(Long string) {
		this.mitarbeiterID = string;
	}

	public void setMitarbeiterName(String name) {
		this.username = name;
	}

	public void setMitarbeiterID(Long string) {
		this.mitarbeiterID = string;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public void setName(String name) {
		this.username = name;
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

	public List<MitarbeiterRegister> getMitarbeiter() {
		return mitarbeiter;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(String workingDays) {
		this.workingDays = workingDays;
	}

}
