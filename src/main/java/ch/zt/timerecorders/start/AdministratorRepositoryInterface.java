package ch.zt.timerecorders.start;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiren Gondal
 */

@Repository("adminRepo")
public interface AdministratorRepositoryInterface extends CrudRepository<Administrator, Integer>{
	
	Optional<Administrator> findUserByName(String name);
	
	


}
