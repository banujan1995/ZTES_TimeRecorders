package ch.zt.timerecorders.businesslogic;

/**
 * @author Banujan Ragunathan
 */

/*
 * Hier werden die Pensa ausgewiesen und auch immer wiederverwendet. Die Quelle
 * der Monatsarbeitsstunden ist nach Berner Finanzdepartement:
 * https://www.fin.be.ch/fin/de/index/personal/anstellungsbedingungen/
 * arbeitszeit/sollarbeitszeit.assetref/dam/documents/FIN/PA/de/
 * Sollarbeitszeittabelle_TZ_2021.pdf (Gemäss Beschluss von CEO von JKB GmbH
 * werden die Pensa min. auf 20er Pensa heruntergebrochen - darunter können keine
 * Vereinbarungen bzw. Vertrag gemäss GAV von JKB gemacht werden.
 * 
 */

public enum Pensum {
	ZwanzigProzent(20), VierzigProzent(40), SechszigProzent(60), AchtzigProzent(80), HundertProzent(100);

	private final int pensum;

	Pensum(int pensum) {
		this.pensum = pensum;
	}

	public int getPensum() {
		return pensum;
	}

}
