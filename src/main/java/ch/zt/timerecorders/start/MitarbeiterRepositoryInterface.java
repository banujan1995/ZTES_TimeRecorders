package ch.zt.timerecorders.start;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


/**
 * @author Kiren Gondal
 */
@Repository
public interface MitarbeiterRepositoryInterface extends JpaRepository<MitarbeiterRegister, Long> {
	
	public List<MitarbeiterRegister> findByMitarbeiterID(Long mitarbeiterID);
	public MitarbeiterRegister findByUsername(String username);

	
	

	 

}
