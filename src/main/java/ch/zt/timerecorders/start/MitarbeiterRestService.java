package ch.zt.timerecorders.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MitarbeiterRestService {
	
	private MitarbeiterRepositoryInterface mitarbeiterRepo;
	
	@PostMapping("/login")
    public String greetingSubmit(@ModelAttribute Mitarbeiter m1) {
 
        Mitarbeiter newMA = new Mitarbeiter();
 
        newMA.setMitarbeiterName(m1.getName());
        newMA.setMitarbeiterVorname(m1.getVorname());
        mitarbeiterRepo.save(m1);
 
        return "successfully saved";
 
    }

}
