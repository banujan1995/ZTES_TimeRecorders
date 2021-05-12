package ch.zt.timerecorders.persistence;

import java.lang.System.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import org.springframework.beans.factory.annotation.Autowired;

import ch.zt.timerecorders.businesslogic.Pensum;

/**
 * @author Banujan Ragunathan
 */

public class Administrator {

	public String administratorID;
	public String name;
	public String vorname;
	public String passwort;
	public Pensum pensum; 
	
	

	

	public Administrator(String vorname, String name, Pensum pensum) {
		this.vorname = vorname;
		this.name = name;
		this.pensum = pensum; 
		
		
	
	}

	public String getAdministratorID() {
		return administratorID;
	}

	public void setAdministratorID(String administratorID) {
		this.administratorID = administratorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	/*
	 * Hier soll das Passwort verschlüsselt werden, um die Sicherheit zu gewährleisten. (BR)
	 * Quelle: https://dzone.com/articles/storing-passwords-java-web
	 */
	
	//Hier wird das Passwort bereits gehasht bevor es abgespeichert wird!
	public String enryptionOfPW(String passwort) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(passwort.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			

		}

		return hash.toString();
		
	}



}
