package ch.zt.timerecorders.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Banujan Ragunathan (Zeiterfassung)
 * @author Kiren Gondal (DB System)
 *
 */

/*
 * Timetable im Datenbank abspeichern (BR)
 */

@Entity
@Table(name = "zeiterfassungen")
public class TimeStampRegisterChange {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int erfassungID;
	private int TAGESID;
	protected String date;
	
	//Hier wird der Username übernommen. 
	private String username; 
	
	//Grund der Erfassung
	protected String grund = ""; 
	
	//Hier wird der Pensum 
	private int pensum; 

	// Stunden Vormittag
	protected int morningstartHours;
	protected int morningEndHours;

	// Minuten Vormittag
	protected double morningStartMinDeci;
	protected double morningEndMinDeci;

	// Summe Vormittag in Dezimal
	protected double morningTotal;

	// Stunden Nachmittag
	protected int afternoonStartHours;
	protected int afternoonEndHours;

	// Minuten Nachmittag
	protected double afternoonStartMinDeci;
	protected double afternoonEndMinDeci;

	// Summe Nachmittag in Dezimal
	protected double afternoonTotal;

	// geleistete Arbeitszeit am einem Tag
	protected double totalDeci;

	//Überzeit vom Vortrag wird reingespeichert. 
	protected double minusOderPlusZeit = 0.0;
	

	public TimeStampRegisterChange(int erfassungID, int tAGESID, String date, int morningstartHours,
			int morningEndHours, double morningStartMinDeci, double morningEndMinDeci, double morningTotal,
			int afternoonStartHours, int afternoonEndHours, double afternoonStartMinDeci, double afternoonEndMinDeci,
			double afternoonTotal, double totalDeci, double minusOderPlusZeit, String grund, int pensum, String username) {
		super();
		this.erfassungID = erfassungID;
		TAGESID = tAGESID;
		this.date = date;
		this.morningstartHours = morningstartHours;
		this.morningEndHours = morningEndHours;
		this.morningStartMinDeci = morningStartMinDeci;
		this.morningEndMinDeci = morningEndMinDeci;
		this.morningTotal = morningTotal;
		this.afternoonStartHours = afternoonStartHours;
		this.afternoonEndHours = afternoonEndHours;
		this.afternoonStartMinDeci = afternoonStartMinDeci;
		this.afternoonEndMinDeci = afternoonEndMinDeci;
		this.afternoonTotal = afternoonTotal;
		this.totalDeci = totalDeci;
		this.minusOderPlusZeit = minusOderPlusZeit;
		this.grund = grund;
		this.pensum = pensum;
		this.username = username; 
	}

	public TimeStampRegisterChange() {

	}

	public int getTAGESID() {
		return TAGESID;
	}

	public void setTAGESID(int tAGESID) {
		TAGESID = tAGESID;
	}

	public int getMitarbeiterID() {
		return erfassungID;
	}

	public void setMitarbeiterID(int erfassungID) {
		this.erfassungID = erfassungID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMorningstartHours() {
		return morningstartHours;
	}

	public void setMorningstartHours(int morningstartHours) {
		this.morningstartHours = morningstartHours;
	}

	public int getMorningEndHours() {
		return morningEndHours;
	}

	public void setMorningEndHours(int morningEndHours) {
		this.morningEndHours = morningEndHours;
	}

	public double getMorningStartMinDeci() {
		return morningStartMinDeci;
	}

	public void setMorningStartMinDeci(double morningStartMinDeci) {
		this.morningStartMinDeci = morningStartMinDeci;
	}

	public double getMorningEndMinDeci() {
		return morningEndMinDeci;
	}

	public void setMorningEndMinDeci(double morningEndMinDeci) {
		this.morningEndMinDeci = morningEndMinDeci;
	}

	public double getMorningTotal() {
		return morningTotal;
	}

	public void setMorningTotal(double morningTotal) {
		this.morningTotal = morningTotal;
	}

	public int getAfternoonStartHours() {
		return afternoonStartHours;
	}

	public void setAfternoonStartHours(int afternoonStartHours) {
		this.afternoonStartHours = afternoonStartHours;
	}

	public int getAfternoonEndHours() {
		return afternoonEndHours;
	}

	public void setAfternoonEndHours(int afternoonEndHours) {
		this.afternoonEndHours = afternoonEndHours;
	}

	public double getAfternoonStartMinDeci() {
		return afternoonStartMinDeci;
	}

	public void setAfternoonStartMinDeci(double afternoonStartMinDeci) {
		this.afternoonStartMinDeci = afternoonStartMinDeci;
	}

	public double getAfternoonEndMinDeci() {
		return afternoonEndMinDeci;
	}

	public void setAfternoonEndMinDeci(double afternoonEndMinDeci) {
		this.afternoonEndMinDeci = afternoonEndMinDeci;
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
	
	
	
	
	
	

}
