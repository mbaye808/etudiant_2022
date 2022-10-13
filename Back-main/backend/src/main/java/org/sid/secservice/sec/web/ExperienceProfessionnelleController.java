package org.sid.secservice.sec.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.ExperienceProfessionnelle;
import org.sid.secservice.sec.repo.ExperienceProfessionnelleRepository;
import org.sid.secservice.sec.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class ExperienceProfessionnelleController {

    @Autowired
    private ExperienceProfessionnelleRepository experienceProfessionnelleRepository;

    @Autowired
	private AccountServiceImpl accountServiceImpl;

    @PostMapping(path = "/experience")
    @CrossOrigin(origins = "http://localhost:4201")
    public ExperienceProfessionnelle saveExperience(@Valid @RequestBody ExperienceProfessionnelle experienceProfessionnelle){
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        experienceProfessionnelle.setIne(appUser.get().getIne());
        ExperienceProfessionnelle experience = experienceProfessionnelleRepository.save(experienceProfessionnelle);

        return experience;
    }
    @PutMapping("/experience/update")
	public void updateExperience(@RequestBody ExperienceProfessionnelle experienceProfessionnelle){
	 experienceProfessionnelleRepository.save(experienceProfessionnelle);
    }
    /* @GetMapping("/experience")
    public List<ExperienceProfessionnelle> getAllExperience() {
        return experienceProfessionnelleRepository.findAll();     
    } */
    @GetMapping("/experience")
    public List<ExperienceProfessionnelle> getAllExperienceByIne() {
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        List<ExperienceProfessionnelle> experience = experienceProfessionnelleRepository.findByIne(appUser.get().getIne());
        return experience;     
    } 
    
}
