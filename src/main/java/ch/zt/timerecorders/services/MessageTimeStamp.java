package ch.zt.timerecorders.services;

public class MessageTimeStamp {

	private Long mitarbeiterID;
	private String date;

	private double vormittagZeitStart;
	private double vormittagZeitEnd;
	private double nachmittagZeitStart;
	private double nachmittagZeitEnd;
	
	private double minusOderPlusZeit;
	
	

	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}

	public void setMitarbeiterID(Long mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getVormittagZeitStart() {
		return vormittagZeitStart;
	}

	public void setVormittagZeitStart(double vormittagZeitStart) {
		this.vormittagZeitStart = vormittagZeitStart;
	}

	public double getVormittagZeitEnd() {
		return vormittagZeitEnd;
	}

	public void setVormittagZeitEnd(double vormittagZeitEnd) {
		this.vormittagZeitEnd = vormittagZeitEnd;
	}

	public double getNachmittagZeitStart() {
		return nachmittagZeitStart;
	}

	public void setNachmittagZeitStart(double nachmittagZeitStart) {
		this.nachmittagZeitStart = nachmittagZeitStart;
	}

	public double getNachmittagZeitEnd() {
		return nachmittagZeitEnd;
	}

	public void setNachmittagZeitEnd(double nachmittagZeitEnd) {
		this.nachmittagZeitEnd = nachmittagZeitEnd;
	}

	public double getMinusOderPlusZeit() {
		return minusOderPlusZeit;
	}

	public void setMinusOderPlusZeit(double minusOderPlusZeit) {
		this.minusOderPlusZeit = minusOderPlusZeit;
	}

	
	
}
