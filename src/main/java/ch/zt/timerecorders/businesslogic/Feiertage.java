package ch.zt.timerecorders.businesslogic;

public enum Feiertage {
	
	Neujahr(20210101), Berchtoldstag(20210102), Karfreitag(20210402), Ostersonntag(20210404), Auffahrt(20210513),
	Pfingstmontag(20210524), Bundesfeier(20210801), EidgenössischerDankBussundBettag(20210919), 
	Weihnachten(20211225), Stephanstag(20211226); 
	
	private final int datum;
	
	Feiertage(int datum){
		this.datum = datum; 
	}

}
