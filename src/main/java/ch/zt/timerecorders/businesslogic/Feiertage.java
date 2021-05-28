package ch.zt.timerecorders.businesslogic;

/**
 * 
 * @author Banujan Ragunathan
 *
 */

/*
 * Hier wird die gesetzliche Feiertage von Kanton Bern übernommen. (BR)
 */

public enum Feiertage {
	
	Neujahr("Fri Jan 01 2021"), Berchtoldstag("Sat Jan 02 2021"), Karfreitag("Fri Apr 02 2021"), Ostersonntag("Sun Apr 04 2021"), Auffahrt("Thu May 13 2021"),
	Pfingstmontag("Mon May 24 2021"), Bundesfeier("Sun Aug 01 2021"), EidgenössischerDankBussundBettag("Sun Sep 19 2021"), 
	Weihnachten("Sat Dec 25 2021"), Stephanstag("Sun Dec 26 2021"); 
	
	private final String datum;
	
	Feiertage(String datum){
		this.datum = datum; 
	}

}
