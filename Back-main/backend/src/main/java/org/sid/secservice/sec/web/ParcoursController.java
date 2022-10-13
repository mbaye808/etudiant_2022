package org.sid.secservice.sec.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Parcours;
import org.sid.secservice.sec.repo.ParcoursRepository;
import org.sid.secservice.sec.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
public class ParcoursController {

    @Autowired
	private ParcoursRepository parcoursRepository;

    @Autowired
	private AccountServiceImpl accountServiceImpl;

    @PostMapping(path = "/parcours")
    @CrossOrigin(origins = "http://localhost:4201")
    public Parcours saveParcours(@Valid @RequestBody Parcours parcours){
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
       parcours.setIne(appUser.get().getIne());
        Parcours parcour = parcoursRepository.save(parcours);

        return parcour;
    }
    @PutMapping("/parcours/update")
	public void updateParcours(@RequestBody Parcours parcours){
	 parcoursRepository.save(parcours);
    }
     @GetMapping("/parcours")
    public List<Parcours> getAllParcoursByIne() {
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        List<Parcours> parcours = parcoursRepository.findByIne(appUser.get().getIne());
        return parcours;     
    } 

     @GetMapping("/parcours/{id}")
	public ResponseEntity<Parcours> getParcoursById(@PathVariable Long id) {
		Parcours parcours = parcoursRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Parcours not exist : " +id));
		return ResponseEntity.ok(parcours);
	}
    /* @GetMapping("/parcours")
	public List<Parcours> getAllParcours(){
		
		return parcoursRepository.findAll();
		
	}  */

   
}
