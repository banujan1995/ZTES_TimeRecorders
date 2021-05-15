package ch.zt.timerecorders.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Banujan Ragunathan
 *
 */

@Component
public class AdministratorenRepository {
	
	private List<Administrator> administratorList = new ArrayList<>();
	private final int START_OF_ADMINISTRATORID = 100;

	public List<Administrator> getAdministratorList() {
		return administratorList;
	}

	//Hier wird der Administrator Hauptklasse in die ArrayList eingetragen.
		public void addAdministrator(Administrator administrator) {
			int localHöchstMöglicheAdminID = 0;
			Administrator localAD;

			// ID wird vor dem Abspeichern noch vergeben als letzter Ansatz (BR)
			boolean freierPlatz = false;

			// freier Platz im Array (BR)
			if (administratorList.size() == 0) {
				freierPlatz = true;
				localHöchstMöglicheAdminID = 0;
				freierPlatz = false;
			} else {

				if (freierPlatz == false) {

					for (int i = 0; i <= administratorList.size() - 1; i++) {
						localAD = administratorList.get(i);
						localHöchstMöglicheAdminID += 1;
					}
					freierPlatz = true;
				}
			}
			administrator.setAdministratorID((long) (START_OF_ADMINISTRATORID + localHöchstMöglicheAdminID));
//			konkatMitarbeiterID(administrator);
			administratorList.add(administrator);

		}
		
//		public void konkatMitarbeiterID(Mitarbeiter mitarbeiter) {
//
//			if (mitarbeiter.getMitarbeiterID() == 0) {
//				System.out.println("Zahl ist 0 - Kommentar weg nehmen");
//
//			}
//		}
//		

		//Soll Objekt mit dem Mitarbeiter zurückgeben bzw. den ganzen Mitarbeiter - mit MitarbeiterID (BR)
		public Administrator getSingleAdministratorID(int administratorID) {
			boolean administratorFound = false;
			Administrator administrator = null;

			for (int i = 0; i <= administratorList.size() - 1; i++) {
				Administrator localAdministrator = administratorList.get(i);

				if (localAdministrator.getAdministratorID() == administratorID) {
					administrator = localAdministrator;
					administratorFound = true;
				} else {
					administratorFound = false; 
				}
			}
			return administrator;
		}
		
		//Soll Objekt mit dem Mitarbeiter zurückgeben bzw. den ganzen Mitarbeiter - mit Name (BR)
		public Administrator getSingleAdministratorName(String name) {
			boolean administratorFound = false;
			Administrator administrator = null;

			for (int i = 0; i <= administratorList.size() - 1; i++) {
				Administrator localAdministrator = administratorList.get(i);

				if (localAdministrator.getName().equalsIgnoreCase(name)) {
					administrator = localAdministrator;
					administratorFound = true;
				}
			}
			return administrator;
		}

}
