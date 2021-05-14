package ch.zt.timerecorders.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.zt.timerecorders.start.MessageNewMA;
import ch.zt.timerecorders.start.Mitarbeiter;
import ch.zt.timerecorders.start.MitarbeiterRepositoryInterface;


@RestController
public class MitarbeiterServices {
	
	@Autowired
	private MitarbeiterRepositoryInterface maRepo;

	@PostMapping(path = "/addEmployee", produces = "application/json")
	public long createNewMa(@RequestBody MessageNewMA m) {


		Mitarbeiter m1 = new Mitarbeiter();
		m1.setIntMitarbeiterID(m.getMitarbeiterId());
		m1.setName(m.getName());
		m1.setPasswort(m.getPasswort());
		m1.setArbeitstagMo(m.isArbeitstagMo());
		m1.setArbeitstagDi(m.isArbeitstagDi());
		m1.setArbeitstagMi(m.isArbeitstagMi());
		m1.setArbeitstagDo(m.isArbeitstagDo());
		m1.setArbeitstagFr(m.isArbeitstagFr());
		m1.setPensum(m.getPensum());
		
		m1 = maRepo.save(m1); // beim Speichern wird eine OrderId automatisch vergeben
		return m1.getMitarbeiterID();
	}
	
	

}
