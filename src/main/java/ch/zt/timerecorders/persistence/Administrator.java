package ch.zt.timerecorders.persistence;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import ch.zt.timerecorders.businesslogic.Pensum;
import ch.zt.timerecorders.start.ServiceLocator;

/**
 * @author Banujan Ragunathan
 */

public class Administrator {

	Logger logger = ServiceLocator.getServiceLocator().getLogger();

	protected Long administratorID;
	protected String mitarbeiterCode = "AD";
	protected String name;
	protected String vorname;
	protected String passwort;
	protected Pensum pensum;

	public Administrator(String vorname, String name, String passwort, Pensum pensum) {
		this.vorname = vorname;
		this.name = name;
		this.pensum = pensum;
//		this.passwort = enryptionOfPW(passwort);		
		this.passwort = passwort;

	}

	public Long getAdministratorID() {
		return administratorID;
	}
	
	public void setAdministratorID(Long administratorID) {
		this.administratorID = administratorID;
	}

	public String getMitarbeiterCode() {
		return mitarbeiterCode;
	}

	public void setMitarbeiterCode(String mitarbeiterCode) {
		this.mitarbeiterCode = mitarbeiterCode;
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

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
//		this.passwort = enryptionOfPW(passwort);
		this.passwort = passwort;
	}

	public Pensum getPensum() {
		return pensum;
	}

	public void setPensum(Pensum pensum) {
		this.pensum = pensum;
	}

	/*
	 * Hier soll das Passwort verschlüsselt werden, um die Sicherheit zu
	 * gewährleisten. (BR) Quelle:
	 * https://dzone.com/articles/storing-passwords-java-web
	 */

	// Hier wird das Passwort bereits gehasht bevor es abgespeichert wird!
//	public String enryptionOfPW(String passwort) {
//		StringBuilder hash = new StringBuilder();
//
//		try {
//			MessageDigest sha = MessageDigest.getInstance("SHA-1");
//			byte[] hashedBytes = sha.digest(passwort.getBytes());
//			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
//			for (int idx = 0; idx < hashedBytes.length; ++idx) {
//				byte b = hashedBytes[idx];
//				hash.append(digits[(b & 0xf0) >> 4]);
//				hash.append(digits[b & 0x0f]);
//			}
//		} catch (NoSuchAlgorithmException e) {
//			logger.warning("Passwort Encryption Failure");
//
//		}
//		System.out.println(hash.toString());
//		return hash.toString();
//
//	}

}
