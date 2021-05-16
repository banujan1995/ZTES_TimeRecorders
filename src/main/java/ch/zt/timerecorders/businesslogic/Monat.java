package ch.zt.timerecorders.businesslogic;

/**
 * @author Banujan Ragunathan
 */

public enum Monat {
	Januar(1), Feburar(2), März(3), April(4), Mai(5), Juni(6), Juli(7), August(8), September(9), Oktober(10),
	November(11), Dezember(12);
	
	private final int monatszahl;

	Monat(int monatszahl) {
		this.monatszahl = monatszahl;
	
	}

}
