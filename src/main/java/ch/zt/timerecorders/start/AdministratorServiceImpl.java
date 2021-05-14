package ch.zt.timerecorders.start;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kiren Gondal
 */

@Transactional
@Service("AdministratorServiceInterface")
public class AdministratorServiceImpl implements AdministratorServiceInterface{
	

		@Autowired
		private AdministratorRepositoryInterface adminRepo;
		
		public AdministratorServiceImpl(AdministratorRepositoryInterface adminRepo) {
			this.adminRepo = adminRepo;
		}
		
		@PostConstruct
		public void LoadData() {
		Administrator admin = new Administrator();
		admin.setAdministratorID(123);
		admin.setName("Admin");
		admin.setPasswort("password");
		
		adminRepo.save(admin);
		}

		@Override
		public Iterable<Administrator> findAll() {
			return adminRepo.findAll();
		}

	}

