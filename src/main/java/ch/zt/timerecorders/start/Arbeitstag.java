package ch.zt.timerecorders.start;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kiren Gondal
 */


@Entity
@Table(name = "arbeitstag")
public class Arbeitstag {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long arbeitstagID;
	public int vmAnfang;
	public int nmAnfang;
	public int vmEnde;
	public int nmEnde;
	public int date;
	public Long ferienID;
	
	public Arbeitstag(Long arbeitstagID, int vmAnfang, int nmAnfang, int vmEnde, int nmEnde, int date, Long ferienID) {
		
		this.arbeitstagID = arbeitstagID;
		this.vmAnfang = vmAnfang;
		this.nmAnfang = nmAnfang;
		this.vmEnde = vmEnde;
		this.nmEnde = nmEnde;
		this.date = date;
		this.ferienID = ferienID;
	}

	public Long getArbeitstagID() {
		return arbeitstagID;
	}

	public void setArbeitstagID(Long arbeitstagID) {
		this.arbeitstagID = arbeitstagID;
	}

	public int getVmAnfang() {
		return vmAnfang;
	}

	public void setVmAnfang(int vmAnfang) {
		this.vmAnfang = vmAnfang;
	}

	public int getNmAnfang() {
		return nmAnfang;
	}

	public void setNmAnfang(int nmAnfang) {
		this.nmAnfang = nmAnfang;
	}

	public int getVmEnde() {
		return vmEnde;
	}

	public void setVmEnde(int vmEnde) {
		this.vmEnde = vmEnde;
	}

	public int getNmEnde() {
		return nmEnde;
	}

	public void setNmEnde(int nmEnde) {
		this.nmEnde = nmEnde;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Long getFerienID() {
		return ferienID;
	}

	public void setFerienID(Long ferienID) {
		this.ferienID = ferienID;
	}
	
	
	


}
