package ch.zt.timerecorders.persistence;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


/**
 * @author Banujan Ragunathan
 */

/*
 * Hier werde die Zeiterfassungen in einem ArrayList gespeichert 
 * und diese soll dann ausgegeben werden. (BR)
 */

@Component
public class ArbeitstagRepository {

	// Repository für die erfasste Zeitdaten
	private List<Arbeitstag> zeiterfassungsRepo = new ArrayList<>();

	public List<Arbeitstag> getZeiterfassungRepo() {
		return zeiterfassungsRepo;
	}
	
	public void addZeiterfassung(Arbeitstag zeiterfassung) {
		zeiterfassungsRepo.add(zeiterfassung);	
	}
	
	public int getSizeArrayList() {
		return zeiterfassungsRepo.size();
	}

	

	
	
	

}
