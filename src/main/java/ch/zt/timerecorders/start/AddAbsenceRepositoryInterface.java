package ch.zt.timerecorders.start;

import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Tabelle im Dokument erstellt und die Methoden für DB zur Verfügung gestellt (KG)
 */

public interface AddAbsenceRepositoryInterface extends JpaRepository<AddAbsence, Integer>  {
}
