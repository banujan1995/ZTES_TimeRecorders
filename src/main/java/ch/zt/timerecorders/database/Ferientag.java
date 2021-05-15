package ch.zt.timerecorders.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Kiren Gondal
 */


@Entity
@Table(name = "ferientag")
public class Ferientag {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	
	
	public Long ferienID;	
	public Long mitarbeiterID;	
	private int tag;
	private int anzahlStd;
	
	
	public Ferientag(Long ferienID, Long mitarbeiterID, int tag, int anzahlStd) {
		super();
		this.ferienID = ferienID;
		this.mitarbeiterID = mitarbeiterID;
		this.tag = tag;
		this.anzahlStd = anzahlStd;
	}


	public Long getFerienID() {
		return ferienID;
	}


	public void setFerienID(Long ferienID) {
		this.ferienID = ferienID;
	}


	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}


	public void setMitarbeiterID(Long mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}


	public int getTag() {
		return tag;
	}


	public void setTag(int tag) {
		this.tag = tag;
	}


	public int getAnzahlStd() {
		return anzahlStd;
	}


	public void setAnzahlStd(int anzahlStd) {
		this.anzahlStd = anzahlStd;
	}
	
	
	
	
	
	
	
	
	

}
