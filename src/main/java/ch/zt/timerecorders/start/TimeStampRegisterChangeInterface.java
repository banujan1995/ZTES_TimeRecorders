package ch.zt.timerecorders.start;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Banujan Ragunathan
 * @author Kiren Gondal
 *
 */

/*
 * Tabelle im Dokument erstellt und die Methoden für DB zur Verfügung gestellt
 * (KG)
 */

public interface TimeStampRegisterChangeInterface extends JpaRepository<TimeStampRegisterChange, Integer> {

}
