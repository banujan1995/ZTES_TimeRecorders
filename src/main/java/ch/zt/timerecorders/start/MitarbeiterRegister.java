package ch.zt.timerecorders.start;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */
@Entity
@Table(name = "mitarbeiter")
public class MitarbeiterRegister {

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
//	@OneToOne(mappedBy = "mitarbeiter", fetch = FetchType.LAZY,
//    cascade = CascadeType.ALL)
	public Long mitarbeiterID;
	
	
	public String surname;
	public String familyname;
	@Column(unique=true)
	public String username;
	public String passwort;
	public String pensum;


	public MitarbeiterRegister(Long mitarbeiterID, String surname, String familyname, String username, String passwort, String pensum) {
		super();
		this.mitarbeiterID = mitarbeiterID;
		this.surname = surname;
		this.familyname = familyname;
		this.username = username;
		this.passwort = passwort;
		this.pensum = pensum;
	}

	public String getPensum() {
		return pensum;
	}
	
	public void setPensum(String string) {
		this.pensum = string;
	}
	
	//noch nicht löschen - Kiren
	public MitarbeiterRegister() {
	}

	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}

	
	public String getName() {
		return username;
	}

	public String getVorname() {
		return passwort;
	}

	public void setIntMitarbeiterID(Long string) {
		this.mitarbeiterID = string;
	}

	public void setMitarbeiterName(String name) {
		this.username = name;
	}

	public void setMitarbeiterVorname(String passwort) {
		this.passwort = passwort;
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
	
	
	

}
