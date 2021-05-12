package ch.zt.timerecorders.businesslogic;

/**
 * @author Banujan Ragunathan
 */

/*
 * Hier werden die maximale Arbeitsstunden nach Pensum ausgewiesen und auch
 * immer wiederverwendet. Die Quelle der Monatsarbeitsstunden ist nach Berner
 * Finanzdepartement:
 * https://www.fin.be.ch/fin/de/index/personal/anstellungsbedingungen/
 * arbeitszeit/sollarbeitszeit.assetref/dam/documents/FIN/PA/de/
 * Sollarbeitszeittabelle_TZ_2021.pdf (Gemäss Beschluss von CEO von JKB GmbH
 * werden die Pensa min. auf 20er Pensa heruntergebrochen - darunter können keine
 * Vereinbarungen bzw. Vertrag gemäss GAV von JKB gemacht werden.
 * 
 */

public enum Jahresarbeitsstunden {

	ZwanzigProzent(428.00), VierzigProzent(856.00), SechszigProzent(1284.00), AchtzigProzent(1712.00), HundertProzent(2140.00);

	private final double jahresarbeitsstunden;

	Jahresarbeitsstunden(double jahresarbeitsstunden) {
		this.jahresarbeitsstunden = jahresarbeitsstunden;

	}

	/*
	 * Mit dieser Methode sollen die Jahresstunden auf die Monatsstunden
	 * heruntergebrochen werden. Benötigte Hilfe beim Switch:
	 * https://stackoverflow.com/questions/6391777/switch-on-enum-in-java
	 * https://stackoverflow.com/questions/3065438/switch-statement-with-returns-
	 * code-correctness
	 * https://wiki.byte-welt.net/wiki/Flie%C3%9Fkommazahlen_mit_Java_runden
	 */
	public double monatsstundenRechner(Monat monat, Pensum pensum) {
		double monatsstunden = 0.0;

		switch (monat) {

		case Januar:
			double monatsverhältnisJan = 1 / 2140 * 168.00;
			monatsstunden = monatsverhältnisJan * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case Feburar:
			double monatsverhältnisFeb = 1 / 2140 * 168.00;
			monatsstunden = monatsverhältnisFeb * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case März:
			double monatsverhältnisMär = 1 / 2140 * 193.20;
			monatsstunden = monatsverhältnisMär * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case April:
			double monatsverhältnisApr = 1 / 2140 * 167.00;
			monatsstunden = monatsverhältnisApr * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case Mai:
			double monatsverhältnisMai = 1 / 2140 * 158.60;
			monatsstunden = monatsverhältnisMai * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case Juni:
			double monatsverhältnisJun = 1 / 2140 * 184.80;
			monatsstunden = monatsverhältnisJun * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case Juli:
			double monatsverhältnisJul = 1 / 2140 * 184.80;
			monatsstunden = monatsverhältnisJul * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case August:
			double monatsverhältnisAug = 1 / 2140 * 184.80;
			monatsstunden = monatsverhältnisAug * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case September:
			double monatsverhältnisSep = 1 / 2140 * 184.80;
			monatsstunden = monatsverhältnisSep * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case Oktober:
			double monatsverhältnisOkt = 1 / 2140 * 176.40;
			monatsstunden = monatsverhältnisOkt * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case November:
			double monatsverhältnisNov = 1 / 2140 * 184.80;
			monatsstunden = monatsverhältnisNov * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		case Dezember:
			double monatsverhältnisDez = 1 / 2140 * 184.80;
			monatsstunden = monatsverhältnisDez * getJahresarbeitsstundenfürBerechnung(pensum);
			break;

		default:
			System.out.println("Er kommt in den Default rein - Achtung");

		}

		return monatsstunden;
	}

	public double getJahresarbeitsstundenfürBerechnung(Pensum pensum) {
		Jahresarbeitsstunden localPensum = Jahresarbeitsstunden.valueOf(pensum.getPensum()+"");
		double localJahresarbeitsstunden = localPensum.getJahresarbeitsstunden();
		return localJahresarbeitsstunden;
	}

	public double getJahresarbeitsstunden() {
		return jahresarbeitsstunden;
	}

}
