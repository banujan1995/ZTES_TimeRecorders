package ch.zt.timerecorders.persistence;

public class MessageTimeStamp {
	
	/**
	 * @author Banujan Ragunathan (Zeiterfassung)
	 * @author Kiren Gondal (DB System)
	 */
	/*
	 * Hier werden die Daten über ein Interface an den Datenbank übergeben. Dazu benötigt es die Klasse Message (BR)
	 */

	private long TAGESID;
	private Long erfassungID;
	private String date; // datum
	
	//Hier wird der Username übernommen. 
	private String username; 
		
	//Hier wird der Grund der Erfassung übernommen. 
	private String grund = ""; 
	
	//Hier wird der Pensum 
	private int pensum; 

	// Stunden Vormittag
	private int morningEndHours;
	private int morningstartHours;

	// Minuten Vormittag
	private double morningEndMinDeci;
	private double morningStartMinDeci;

	// Stunden Nachmittag
	private int afternoonEndHours;
	private int afternoonStartHours;

	// Minuten Nachmittag
	private double afternoonEndMinDeci;
	private double afternoonStartMinDeci;

	// Summe Stunden und Minuten (in Dezimal)
	private double morningTotal; // in Dezimal
	private double afternoonTotal; // in Dezimal
	
	// geleistete Arbeitszeit am einem Tag
	private double totalDeci;
	
	//Hier wird die Überzeit mitgenommen vom vorherigen Tag. 
	private double minusOderPlusZeit;

	// Zeit, welches zu arbeiten ist
	protected double targettime;

	public long getTAGESID() {
		return TAGESID;
	}

	public void setTAGESID(long tAGESID) {
		TAGESID = tAGESID;
	}

	public Long getMitarbeiterID() {
		return erfassungID;
	}

	public void setMitarbeiterID(Long erfassungID) {
		this.erfassungID = erfassungID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMorningEndHours() {
		return morningEndHours;
	}

	public void setMorningEndHours(int morningEndHours) {
		this.morningEndHours = morningEndHours;
	}

	public int getMorningstartHours() {
		return morningstartHours;
	}

	public void setMorningstartHours(int morningstartHours) {
		this.morningstartHours = morningstartHours;
	}

	public double getMorningEndMinDeci() {
		return morningEndMinDeci;
	}

	public void setMorningEndMinDeci(double morningEndMinDeci) {
		this.morningEndMinDeci = morningEndMinDeci;
	}

	public double getMorningStartMinDeci() {
		return morningStartMinDeci;
	}

	public void setMorningStartMinDeci(double morningStartMinDeci) {
		this.morningStartMinDeci = morningStartMinDeci;
	}

	public int getAfternoonEndHours() {
		return afternoonEndHours;
	}

	public void setAfternoonEndHours(int afternoonEndHours) {
		this.afternoonEndHours = afternoonEndHours;
	}

	public int getAfternoonStartHours() {
		return afternoonStartHours;
	}

	public void setAfternoonStartHours(int afternoonStartHours) {
		this.afternoonStartHours = afternoonStartHours;
	}

	public double getAfternoonEndMinDeci() {
		return afternoonEndMinDeci;
	}

	public void setAfternoonEndMinDeci(double afternoonEndMinDeci) {
		this.afternoonEndMinDeci = afternoonEndMinDeci;
	}

	public double getAfternoonStartMinDeci() {
		return afternoonStartMinDeci;
	}

	public void setAfternoonStartMinDeci(double afternoonStartMinDeci) {
		this.afternoonStartMinDeci = afternoonStartMinDeci;
	}

	public double getMorningTotal() {
		return morningTotal;
	}

	public void setMorningTotal(double morningTotal) {
		this.morningTotal = morningTotal;
	}

	public double getAfternoonTotal() {
		return afternoonTotal;
	}

	public void setAfternoonTotal(double afternoonTotal) {
		this.afternoonTotal = afternoonTotal;
	}

	public double getTotalDeci() {
		return totalDeci;
	}

	public void setTotalDeci(double totalDeci) {
		this.totalDeci = totalDeci;
	}

	public double getMinusOderPlusZeit() {
		return minusOderPlusZeit;
	}

	public void setMinusOderPlusZeit(double minusOderPlusZeit) {
		this.minusOderPlusZeit = minusOderPlusZeit;
	}

	public String getGrund() {
		return grund;
	}

	public void setGrund(String grund) {
		this.grund = grund;
	}

	public int getPensum() {
		return pensum;
	}

	public void setPensum(int pensum) {
		this.pensum = pensum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getTargettime() {
		return targettime;
	}

	public void setTargettime(double targettime) {
		this.targettime = targettime;
	}
	
}
