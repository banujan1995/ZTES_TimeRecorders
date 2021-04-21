package ch.zt.timerecorders.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ch.zt.timerecorders.businesslogic.Mitarbeiter;

/**
 * @author Banujan Ragunathan
 */

@Component
public class MitarbeiterRepository {

	private List<Mitarbeiter> mitarbeiterList = new ArrayList<>();
	private final int START_OF_MITARBEITERID = 100;
	public final String MITARBEITER_CODE = "MA";

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
		mitarbeiter.setIntMitarbeiterID(START_OF_MITARBEITERID + localHöchstMöglicheMitarbeiterID);
		konkatMitarbeiterID(mitarbeiter);
		mitarbeiterList.add(mitarbeiter);

	}

	public Mitarbeiter getSingleMitarbeiter(String mitarbeiterID) {
		boolean mitarbeiterFound = false;
		Mitarbeiter mitarbeiter = null;
		int localMitarbeiterID = Integer.parseInt(mitarbeiterID.trim().substring(3));

		for (int i = 0; i <= mitarbeiterList.size(); i++) {
			Mitarbeiter localMitarbeiter = mitarbeiterList.get(i);

			if (localMitarbeiter.getId() == localMitarbeiterID) {
				mitarbeiter = localMitarbeiter;
				mitarbeiterFound = true;
			}
		}
		return mitarbeiter;
	}

	public void konkatMitarbeiterID(Mitarbeiter mitarbeiter) {

		if (mitarbeiter.getId() == 0) {
			System.out.println("Zahl ist 0 - Kommentar weg nehmen");

		} else {
			mitarbeiter.setMitarbeiterID(MITARBEITER_CODE + mitarbeiter.getId() + "");
		}
	}

}
