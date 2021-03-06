package ch.zt.timerecorders.start;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * @author Kiren Gondal
 */

/*
 * Tabelle im Dokument erstellt und die Methoden für DB zur Verfügung gestellt (KG)
 */

@Repository
public interface MitarbeiterRepositoryInterface extends JpaRepository<MitarbeiterRegister, Long> {
	
	public List<MitarbeiterRegister> findByMitarbeiterID(long mitarbeiterID);
	

	 

}
