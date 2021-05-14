package ch.zt.timerecorders.start;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Kiren Gondal
 */


@RestController
@RequestMapping("/mitarbeiter")
public class MitarbeiterRestService {
	
	private MitarbeiterRepositoryInterface mitarbeiterRepo;
	
//	@RequestMapping(
//			  value = "/login", 
//			  produces = "application/json", 
//			  method = RequestMethod.POST)
//    public Mitarbeiter addMitarbeiter(
//        @RequestBody Mitarbeiter mitarbeiter)
//    {
//        return mitarbeiterRepo.save(mitarbeiter);
//    }
	

	//Create a new Mitarbeiter
    @PostMapping(path = "/api/addEmployee", produces = "application/json")
    public Mitarbeiter createMitarbeiter(@RequestBody MessageNewMA m) {
    	
    	Mitarbeiter mitarbeiter = new Mitarbeiter();
    	mitarbeiter.setName(m.getName());
    	mitarbeiter.setPasswort(m.getPasswort());
    	mitarbeiter.setArbeitstagMo(m.isArbeitstagMo());
    	mitarbeiter.setArbeitstagDi(m.isArbeitstagDi());
    	mitarbeiter.setArbeitstagMi(m.isArbeitstagMi());
    	mitarbeiter.setArbeitstagDo(m.isArbeitstagDo());
    	mitarbeiter.setArbeitstagFr(m.isArbeitstagFr());
    	mitarbeiter.setPensum(m.getPensum()); 	
    	
    	
        return mitarbeiterRepo.save(mitarbeiter);
    }

	
//	@PostMapping("/login")
//    public String dataSubmit(@ModelAttribute Mitarbeiter m1) {
// 
//        Mitarbeiter newMA = new Mitarbeiter();
// 
//        newMA.setMitarbeiterName(m1.getName());
//        newMA.setMitarbeiterVorname(m1.getVorname());
//        mitarbeiterRepo.save(m1);
// 
//        return "successfully saved";
// 
//    }

}
