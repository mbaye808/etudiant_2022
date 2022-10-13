package org.sid.secservice.sec.web;


import java.util.List;
import javax.validation.Valid;
import org.sid.secservice.sec.entities.AnneePromo;
import org.sid.secservice.sec.repo.AnneePromoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class AnneePromoController {
    
    @Autowired
    private AnneePromoRepository anneePromoRepository;

    @PostMapping(path = "/anneePromo")
    @CrossOrigin(origins = "http://localhost:4201")
    public AnneePromo saveAnneePromo (@Valid @RequestBody AnneePromo anneePromo){
        AnneePromo annee = anneePromoRepository.save(anneePromo);
        return annee;
    }
    @PutMapping("/anneePromo/update")
	public void updateAnneePromo(@RequestBody AnneePromo anneePromo){
	 anneePromoRepository.save(anneePromo);
    }
    @GetMapping("/anneePromo")
    public List<AnneePromo> getAllAnneePromo() {
        return anneePromoRepository.findAll();     
    }
}
