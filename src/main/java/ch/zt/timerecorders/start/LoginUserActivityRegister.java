package ch.zt.timerecorders.start;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Banujan Ragunathan
 * @author Jordi Schmidlin
 *
 */

@Entity
@Table(name = "registeruser")
public class LoginUserActivityRegister {

	/*
	 * Folgende Information werden im Datenbank gespeichert, welche von jeder HTML
	 * Seite abgerufen.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int erfassteOnlineUser;

	private String ip;

	private String username;

	public LoginUserActivityRegister(int erfassteOnlineUser, String ip, String username) {

		super();
		this.erfassteOnlineUser = erfassteOnlineUser;
		this.ip = ip;
		this.username = username;

	}

	public LoginUserActivityRegister() {
	}

	public int getErfassteOnlineUser() {
		return erfassteOnlineUser;
	}

	public void setErfassteOnlineUser(int erfassteOnlineUser) {
		this.erfassteOnlineUser = erfassteOnlineUser;
	}

	public String getIP() {
		return ip;
	}

	public void setIP(String ip) {
		this.ip = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}