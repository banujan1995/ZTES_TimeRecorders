package ch.zt.timerecorders.start;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */

/*
 * Tabelle im Datenbank (BR)
 */

@Entity
@Table(name = "zeiterfassungen")
public class TimeStampRegisterChange {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mitarbeiterID;

	private int TAGESID;

	protected String date;

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
	private double totalDeci;

	protected double minusOderPlusZeit = 0.0;

	public TimeStampRegisterChange(int mitarbeiterID, int tAGESID, String date, int morningstartHours,
			int morningEndHours, double morningStartMinDeci, double morningEndMinDeci, double morningTotal,
			int afternoonStartHours, int afternoonEndHours, double afternoonStartMinDeci, double afternoonEndMinDeci,
			double afternoonTotal, double totalDeci, double minusOderPlusZeit) {
		super();
		this.mitarbeiterID = mitarbeiterID;
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
		return mitarbeiterID;
	}

	public void setMitarbeiterID(int mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
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

}
