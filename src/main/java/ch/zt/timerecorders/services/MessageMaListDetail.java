package ch.zt.timerecorders.services;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Kiren Gondal
 *
 */

public class MessageMaListDetail {
	
	private Long mitarbeiterID;
	private String username;
	private String pensum;
	private List<MessageMaList> maList = new ArrayList();

	public List<MessageMaList> getMaList() {
		return maList;
	}
	
	

	public Long getMitarbeiterID() {
		return mitarbeiterID;
	}

	public void setMitarbeiterID(Long mitarbeiterID) {
		this.mitarbeiterID = mitarbeiterID;
	}

	public void setMaList(List<MessageMaList> maList) {
		this.maList = maList;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
		
	}

	public String getPensum() {
		return pensum;
	}

	public void setPensum(String pensum) {
		this.pensum = pensum;
	}
	
	
	
	
	
	

}
