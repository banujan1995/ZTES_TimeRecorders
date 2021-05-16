package ch.zt.timerecorders.businesslogic;

import java.util.logging.Logger;
import ch.zt.timerecorders.start.ServiceLocator;

/**
 * @author Banujan Ragunathan
 */

/*
 * Diese Klasse soll zur Umrechnung von Zahlen zu Dezimal und umgekehrt dienen.
 * Die Zahlen auf der Webseite sollen in Zeitformat zur Einfachheit für die Mitarbeiter
 * dargestellt werden. Die Berechnung auf dem Server soll auf Dezimalstanard stattfinden.
 */

public class Umrechner {

	Logger logger = ServiceLocator.getServiceLocator().getLogger();

	private final int MAX_ZEIT = 59;
	private final int MIN_ZEIT = 0;

	public double umwandlerInDezimal(double minuten) {
		double dezimal;

		// Rechner
		double localCal = (1 / 60) * minuten;
		dezimal = localCal;

		return dezimal;
	}

	public double umwandlerInMinuten(double dezimal) {
		double minuten;

		// Rechner
		double localCal = dezimal * 60;

		if (MIN_ZEIT >= 0 && localCal < MAX_ZEIT) {
			minuten = localCal;
			logger.info("Die Minuten befinden sich innerhalb 0 und 60");

		} else {
			minuten = 0.0;
			logger.info("Die Minuten befinden sich ausserhalb von 60 und unterhalb 0");

		}

		return minuten;
	}

}
