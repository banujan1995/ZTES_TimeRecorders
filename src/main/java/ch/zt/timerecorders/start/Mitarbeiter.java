package ch.zt.timerecorders.start;

import javax.persistence.CascadeType;
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
public class Mitarbeiter {

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
//	@OneToOne(mappedBy = "mitarbeiter", fetch = FetchType.LAZY,
//    cascade = CascadeType.ALL)
	public Long mitarbeiterID;
	
	public String name;
	public String passwort;
	public boolean arbeitstagMo;
	public boolean arbeitstagDi;
	public boolean arbeitstagMi;
	public boolean arbeitstagDo;
	public boolean arbeitstagFr;
	public int pensum;


	
	public Mitarbeiter(Long mitarbeiterID, String name, String passwort, boolean arbeitstagMo, boolean arbeitstagDi,
			boolean arbeitstagMi, boolean arbeitstagDo, boolean arbeitstagFr, int pensum) {
		super();
		this.mitarbeiterID = mitarbeiterID;
		this.name = name;
		this.passwort = passwort;
		this.arbeitstagMo = arbeitstagMo;
		this.arbeitstagDi = arbeitstagDi;
		this.arbeitstagMi = arbeitstagMi;
		this.arbeitstagDo = arbeitstagDo;
		this.arbeitstagFr = arbeitstagFr;
		this.pensum = pensum;
	}

	
	public int getPensum() {
		return pensum;
	}
	
	public void setPensum(int pensum) {
		this.pensum = pensum;
	}
	
	//noch nicht löschen - Kiren
	public Mitarbeiter() {
	}

	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}

	
	public String getName() {
		return name;
	}

	public String getVorname() {
		return passwort;
	}

	public void setIntMitarbeiterID(Long string) {
		this.mitarbeiterID = string;
	}

	public void setMitarbeiterName(String name) {
		this.name = name;
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
		this.name = name;
	}

	public boolean isArbeitstagMo() {
		return arbeitstagMo;
	}

	public void setArbeitstagMo(boolean arbeitstagMo) {
		this.arbeitstagMo = arbeitstagMo;
	}

	public boolean isArbeitstagDi() {
		return arbeitstagDi;
	}

	public void setArbeitstagDi(boolean arbeitstagDi) {
		this.arbeitstagDi = arbeitstagDi;
	}

	public boolean isArbeitstagMi() {
		return arbeitstagMi;
	}

	public void setArbeitstagMi(boolean arbeitstagMi) {
		this.arbeitstagMi = arbeitstagMi;
	}

	public boolean isArbeitstagDo() {
		return arbeitstagDo;
	}

	public void setArbeitstagDo(boolean arbeitstagDo) {
		this.arbeitstagDo = arbeitstagDo;
	}

	public boolean isArbeitstagFr() {
		return arbeitstagFr;
	}

	public void setArbeitstagFr(boolean arbeitstagFr) {
		this.arbeitstagFr = arbeitstagFr;
	}
	

}
