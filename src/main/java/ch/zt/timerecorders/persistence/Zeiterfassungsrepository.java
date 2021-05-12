package ch.zt.timerecorders.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Zeiterfassungsrepository {

	// Repository für die erfasste Zeitdaten
	private List<Zeiterfassung> zeiterfassungsRepo = new ArrayList<>();

	public List<Zeiterfassung> getZeiterfassungRepo() {
		return zeiterfassungsRepo;
	}
	
	public void addZeiterfassung(Zeiterfassung zeiterfassung) {
		zeiterfassungsRepo.add(zeiterfassung);	
	}
	
	
	

}
