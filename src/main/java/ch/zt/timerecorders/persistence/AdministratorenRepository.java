package ch.zt.timerecorders.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ch.zt.timerecorders.start.Administrator;

/**
 * 
 * @author Banujan Ragunathan
 *
 */

@Component
public class AdministratorenRepository {
	
	private List<Administrator> administratorList = new ArrayList<>();
	private final int START_OF_ADMINISTRATORID = 100;
	public final String ADMINISTRATOR_CODE = "AD";

	public List<Administrator> getAdministratorList() {
		return administratorList;
	}

	// Hier wird der Administrator Hauptklasse in die ArrayList eingetragen.
	public void addAdministrator(Administrator administrator) {
		int localHöchstMöglicheAdministratorID = 0;

		// ID wird vor dem Abspeichern noch vergeben als letzter Ansatz (BR)
		boolean freierPlatz = false;

		// freier Platz im Array (BR)
		if (administratorList.size() == 0) {
			localHöchstMöglicheAdministratorID = 0;
		} else {

			if (freierPlatz == false) {

				for (int i = 0; i <= administratorList.size() - 1; i++) {
					localHöchstMöglicheAdministratorID += 1;
				}
				freierPlatz = true;
			
			}
		}
	}
//		}	administrator.setId(START_OF_ADMINISTRATORID + localHöchstMöglicheAdministratorID);
//		konkatAdministratorID(administrator);
//		administratorList.add(administrator);
//
//	}
	

//	//Diese Methode soll dienen, um die einzelne Mitarbeiter aus der Liste herauszulesen (BR)
//	public Administrator getSingleMitarbeiter(String administratorID) {
//		boolean administratorFound = false;
//		Administrator administrator = null;
//		int localAdministratorID = Integer.parseInt(administratorID.trim().substring(3));

//		for (int i = 0; i <= administratorList.size(); i++) {
//			Administrator localAdministrator = administratorList.get(i);
//
//			if (localAdministrator.getId() == localAdministratorID) {
//				administrator = localAdministrator;
//				administratorFound = true;
//			}
//		}
//		return administrator;
//	}
//
//	public void konkatAdministratorID(Administrator administrator) {
//
//		if (administrator.getId() == 0) {
//			System.out.println("Zahl ist 0 - Kommentar weg nehmen");
//
//		} else {
//			administrator.setAdministratorID(ADMINISTRATOR_CODE + administrator.getId() + "");
//		}
//	}

}
