package ch.zt.timerecorders.start;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Kiren Gondal
 */
@Repository
public interface MitarbeiterRepositoryInterface extends JpaRepository<Mitarbeiter, Long> {
	
	public List<Mitarbeiter> findByMitarbeiterID(long mitarbeiterID);
	

	 

}
