package ch.zt.timerecorders.start;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Banujan Ragunathan
 * @author Jordi Schmidlin
 *
 */

/*
 * Tabelle im Dokument erstellt und die Methoden für DB zur Verfügung gestellt (KG)
 */

public interface  LoginUserActivityRegisterInterface extends JpaRepository<LoginUserActivityRegister, Integer> {

}