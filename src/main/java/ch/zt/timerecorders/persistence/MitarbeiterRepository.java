package ch.zt.timerecorders.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ch.zt.timerecorders.start.MitarbeiterRegister;

/**
 * @author Banujan Ragunathan
 */

@Component
public class MitarbeiterRepository {
	private List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
	private final int START_OF_MITARBEITERID = 100;
	

	public List<Mitarbeiter> getMitarbeiterList() {
		return mitarbeiterList;
	}

	//Hier wird der Mitarbeiter Hauptklasse in die ArrayList eingetragen.
	public void addMitarbeiter(Mitarbeiter mitarbeiter) {
		int localHöchstMöglicheMitarbeiterID = 0;
		Mitarbeiter localMB;

		// ID wird vor dem Abspeichern noch vergeben als letzter Ansatz (BR)
		boolean freierPlatz = false;

		// freier Platz im Array (BR)
		if (mitarbeiterList.size() == 0) {
			freierPlatz = true;
			localHöchstMöglicheMitarbeiterID = 0;
			freierPlatz = false;
		} else {

			if (freierPlatz == false) {

				for (int i = 0; i <= mitarbeiterList.size() - 1; i++) {
					localMB = mitarbeiterList.get(i);
					localHöchstMöglicheMitarbeiterID += 1;
				}
				freierPlatz = true;
			}
		}
		mitarbeiter.setMitarbeiterID((long) (START_OF_MITARBEITERID + localHöchstMöglicheMitarbeiterID));
//		konkatMitarbeiterID(mitarbeiter);
		mitarbeiterList.add(mitarbeiter);

	}
	
//	public void konkatMitarbeiterID(Mitarbeiter mitarbeiter) {
//
//		if (mitarbeiter.getMitarbeiterID() == 0) {
//			System.out.println("Zahl ist 0 - Kommentar weg nehmen");
//
//		}
//	}
	

	//Soll Objekt mit dem Mitarbeiter zurückgeben bzw. den ganzen Mitarbeiter - mit MitarbeiterID (BR)
	public Mitarbeiter getSingleMitarbeiterID(int mitarbeiterID) {
		boolean mitarbeiterFound = false;
		Mitarbeiter mitarbeiter = null;

		for (int i = 0; i <= mitarbeiterList.size() - 1; i++) {
			Mitarbeiter localMitarbeiter = mitarbeiterList.get(i);

			if (localMitarbeiter.getMitarbeiterID() == mitarbeiterID) {
				mitarbeiter = localMitarbeiter;
				mitarbeiterFound = true;
			} else {
				mitarbeiterFound = false; 
			}
		}
		return mitarbeiter;
	}
	
	//Soll Objekt mit dem Mitarbeiter zurückgeben bzw. den ganzen Mitarbeiter - mit Name (BR)
	public Mitarbeiter getSingleMitarbeiterName(String name) {
		boolean mitarbeiterFound = false;
		Mitarbeiter mitarbeiter = null;

		for (int i = 0; i <= mitarbeiterList.size() - 1; i++) {
			Mitarbeiter localMitarbeiter = mitarbeiterList.get(i);

			if (localMitarbeiter.getName().equalsIgnoreCase(name)) {
				mitarbeiter = localMitarbeiter;
				mitarbeiterFound = true;
			}
		}
		return mitarbeiter;
	}

	
}