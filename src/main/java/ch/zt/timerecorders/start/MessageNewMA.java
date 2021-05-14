package ch.zt.timerecorders.start;

import java.util.Date;

public class MessageNewMA {
	
	private Long mitarbeiterId;
	
	public String name;
	public String passwort;
	public boolean arbeitstagMo;
	public boolean arbeitstagDi;
	public boolean arbeitstagMi;
	public boolean arbeitstagDo;
	public boolean arbeitstagFr;
	public int pensum;

	
	public Long getMitarbeiterId() {
		return mitarbeiterId;
	}

	public void setMitarbeiterId(Long mitarbeiterId) {
		this.mitarbeiterId = mitarbeiterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public boolean isArbeitstagMo() {
		return arbeitstagMo;
	}

	public void setArbeitstagMo(boolean arbeitstagMo) {
		this.arbeitstagMo = arbeitstagMo;
	}

	public boolean isArbeitstagDi() {
		return arbeitstagDi;
	}

	public void setArbeitstagDi(boolean arbeitstagDi) {
		this.arbeitstagDi = arbeitstagDi;
	}

	public boolean isArbeitstagMi() {
		return arbeitstagMi;
	}

	public void setArbeitstagMi(boolean arbeitstagMi) {
		this.arbeitstagMi = arbeitstagMi;
	}

	public boolean isArbeitstagDo() {
		return arbeitstagDo;
	}

	public void setArbeitstagDo(boolean arbeitstagDo) {
		this.arbeitstagDo = arbeitstagDo;
	}

	public boolean isArbeitstagFr() {
		return arbeitstagFr;
	}

	public void setArbeitstagFr(boolean arbeitstagFr) {
		this.arbeitstagFr = arbeitstagFr;
	}


	public int getPensum() {
		return pensum;
	}

	public void setPensum(int pensum) {
		this.pensum = pensum;
	}
	
	


}
