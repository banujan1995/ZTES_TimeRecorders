package ch.zt.timerecorders.businesslogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.zt.timerecorders.persistence.MitarbeiterRepository;


public class MessageMADetails {

	private Long mitarbeiterID;
	private List<MitarbeiterRepository> allMitarbeiter = new ArrayList<>();
	
	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}
	public void setMitarbeiterID(Long mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}
	public List<MitarbeiterRepository> getAllMitarbeiter() {
		return allMitarbeiter;
	}
	public void setAllMitarbeiter(List<MitarbeiterRepository> allMitarbeiter) {
		this.allMitarbeiter = allMitarbeiter;
	}
}

