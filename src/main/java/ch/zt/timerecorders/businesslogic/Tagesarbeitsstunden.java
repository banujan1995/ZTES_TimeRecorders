package ch.zt.timerecorders.businesslogic;

/*
 * Hier werden die Tagesarbeitsstunden nach Pensum ausgewiesen. Die Quelle der Tagesarbeitsstunden ist nach Berner
 * Finanzdepartement:
 * https://www.fin.be.ch/fin/de/index/personal/anstellungsbedingungen/
 * arbeitszeit/sollarbeitszeit.assetref/dam/documents/FIN/PA/de/
 * Sollarbeitszeittabelle_TZ_2021.pdf (Gemäss Beschluss von CEO von JKB GmbH
 * werden die Pensa min. auf 20er Pensa heruntergebrochen - darunter können keine
 * Vereinbarungen bzw. Vertrag gemäss GAV von JKB gemacht werden.
 * 
 */

public enum Tagesarbeitsstunden {

	Januar(8.40), Feburar(8.40), März(9.66), April(8.35), Mai(7.93), Juni(9.24), Juli(9.24), August(9.24),
	September(9.24), Oktober(8.82), November(9.24), Dezember(9.24);

	private final double tagesarbeitsstunden;

	Tagesarbeitsstunden(double tagesarbeitsstunden) {
		this.tagesarbeitsstunden = tagesarbeitsstunden;

	}

	public double getArbeitsstundenproTag(int monat) {
		double arbeitsstunden = 0.0;

		switch (monat) {
		
		case 1:
			arbeitsstunden = Januar.getTagesarbeitsstunden();
			break;

		case 2:
			arbeitsstunden = Feburar.getTagesarbeitsstunden();
			break;

		case 3:
			arbeitsstunden = März.getTagesarbeitsstunden();
			break;

		case 4:
			arbeitsstunden = April.getTagesarbeitsstunden();
			break;

		case 05:
			arbeitsstunden = Mai.getTagesarbeitsstunden();
			break;

		case 6:
			arbeitsstunden = Juni.getTagesarbeitsstunden();
			break;

		case 7:
			arbeitsstunden = Juli.getTagesarbeitsstunden();
			break;

		case 8:
			arbeitsstunden = August.getTagesarbeitsstunden();
			break;

		case 9:
			arbeitsstunden = September.getTagesarbeitsstunden();
			break;

		case 10:
			arbeitsstunden = Oktober.getTagesarbeitsstunden();
			break;

		case 11:
			arbeitsstunden = November.getTagesarbeitsstunden();
			break;

		case 12:
			arbeitsstunden = Dezember.getTagesarbeitsstunden();
			break;

		default:
			System.out.println("Er kommt in den Default rein - Achtung");

		}

		return arbeitsstunden;
	}

	

	public double getTagesarbeitsstunden() {
		return tagesarbeitsstunden;
	}

}
