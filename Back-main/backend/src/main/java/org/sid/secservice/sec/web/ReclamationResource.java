package org.sid.secservice.sec.web;

import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Reclamation;
import org.sid.secservice.sec.entities.ReclamationCopy;
import org.sid.secservice.sec.repo.AnneeAccademiqueRepository;
import org.sid.secservice.sec.repo.ReclamationRepository;
import org.sid.secservice.sec.service.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.Instant;

/**
 * REST controller for managing {@link sn.esp.pgi.domain.Reclamation}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ReclamationResource {

    private final Logger log = LoggerFactory.getLogger(ReclamationResource.class);

    private static final String ENTITY_NAME = "reclamation";

    @Autowired
    private AnneeAccademiqueRepository anneeAccademiqueRepository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    private final ReclamationRepository reclamationRepository;

    public ReclamationResource(ReclamationRepository reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    @PostMapping("/reclamations")
    public Reclamation createReclamation(@RequestBody Reclamation reclamation){
        log.debug("REST request to save Reclamation : {}", reclamation);
        reclamation.setAnneeAccademique(anneeAccademiqueRepository.findByActifTrue());
        reclamation.setDate(Instant.now());
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        reclamation.setIne(appUser.get().getIne());
        Reclamation result = reclamationRepository.save(reclamation);
        return result;
    }

    @GetMapping("/reclamations")
    public List<ReclamationCopy> getAllReclamations() {
        log.debug("REST request to get a page of Reclamations");
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        List<ReclamationCopy> reclamations=new ArrayList<>();
        for (Reclamation reclamation : reclamationRepository.findByAnneeAccademiqueActifTrueAndIne(appUser.get().getIne())) {
            reclamations.add(reclamationCopy(reclamation)); 
        }
        return reclamations;     
    }

    @GetMapping("/listeElementReclamationEtudiant/{idgroupe}")
	public List<ReclamationCopy> reclamations(@PathVariable Long idgroupe){
        List<ReclamationCopy> reclamations=new ArrayList<>();
        for (Reclamation reclamation : reclamationRepository.findByAnneeAccademiqueActifTrueAndGroupeId(idgroupe)) {
            reclamations.add(reclamationCopy(reclamation));
        }
		return reclamations;
	}

    @PutMapping("/listeElementReclamationEtudiant/update")
	public void updateReclamation(@RequestBody Reclamation reclamation){
	 reclamationRepository.save(reclamation);
    }


    @PostMapping("/listeElementReclamationEtudiant")
	public List<ReclamationCopy> reclamationsEnseignant(@RequestBody List<Long> idEcs){
        System.out.println(idEcs);
        List<ReclamationCopy> reclamations=new ArrayList<>();
        for (Reclamation reclamation : this.reclamationRepository.findByAnneeAccademiqueActifTrue()) {
            if(reclamation.getHistoriqueElementContitutif()!=null && idEcs.contains(reclamation.getHistoriqueElementContitutif().getId())){
                   reclamations.add(reclamationCopy(reclamation));

            }
              
        }
		return reclamations;
	}

    public ReclamationCopy reclamationCopy(Reclamation reclamation){
        ReclamationCopy reclamationCopy=new ReclamationCopy();
        reclamationCopy.setAnneeAccademique(reclamation.getAnneeAccademique());
        reclamationCopy.setGroupe(reclamation.getGroupe());
        reclamationCopy.setDescription(reclamation.getDescription());
        reclamationCopy.setEtat(reclamation.getEtat());
        reclamationCopy.setSemestre(reclamation.getSemestre());
        reclamationCopy.setSession(reclamation.getSession());
        reclamationCopy.setNature(reclamation.getNature());
        reclamationCopy.setPhoto(reclamation.getPhoto());
        reclamationCopy.setPhotoContentType(reclamation.getPhotoContentType());
        reclamationCopy.setIne(reclamation.getIne());
        reclamationCopy.setId(reclamation.getId());
        reclamationCopy.setHistoriqueElementContitutif(reclamation.getHistoriqueElementContitutif());
        reclamationCopy.setTypeReclamation(reclamation.getTypeReclamation());
        reclamationCopy.setDate(reclamation.getDate().toString());
        if(reclamation.getDateDebut()!=null)
         reclamationCopy.setDateDebut(reclamation.getDateDebut().toString());
        if(reclamation.getDateFin()!=null)
         reclamationCopy.setDateFin(reclamation.getDateFin().toString());

         return reclamationCopy;
    }

     @DeleteMapping("/reclamationsEtudiant/{id}")
     public ResponseEntity<Map<String, Boolean>> deleteReclamation(@PathVariable Long id){
		Reclamation reclamation = reclamationRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Reclamation not exist : " +id));
		reclamationRepository.delete(reclamation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
   
}
