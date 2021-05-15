package ch.zt.timerecorders.database;


import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 */


@Entity
@Table(name = "admin")
public class Administrator implements UserDetails{
	
	
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
	public int administratorID;
    
	public String name;
	public String passwort;

	public Administrator(int administratorID, String name, String passwort) {
	
		this.administratorID = administratorID;
		this.name = name;
		this.passwort = passwort;
	}
	

	public Administrator() {
	}


	public int getAdministratorID() {
		return administratorID;
	}

	public void setAdministratorID(int administratorID) {
		this.administratorID = administratorID;
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


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPassword() {
		return getPassword();
	}


	@Override
	public String getUsername() {
		return getName();
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
