package org.sid.secservice.sec.web;



import org.sid.secservice.sec.entities.AnneeAccademique;
import org.sid.secservice.sec.repo.AnneeAccademiqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for managing {@link sn.esp.pgi.domain.AnneeAccademique}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class AnneeAccademiqueResource {

    private final Logger log = LoggerFactory.getLogger(AnneeAccademiqueResource.class);

    private static final String ENTITY_NAME = "anneeAccademique";

    // @Value("${jhipster.clientApp.name}")
    // private String applicationName;

    private final AnneeAccademiqueRepository anneeAccademiqueRepository;
    public AnneeAccademiqueResource(AnneeAccademiqueRepository anneeAccademiqueRepository) {
        this.anneeAccademiqueRepository = anneeAccademiqueRepository;
    }
    /**
     * {@code GET  /annee-accademiques} : get all the anneeAccademiques.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of anneeAccademiques in body.
     */
    @GetMapping("/annee-accademiques")
    public List<AnneeAccademique> getAllAnneeAccademiques() {
        log.debug("REST request to get all AnneeAccademiques");
        return anneeAccademiqueRepository.findAllByOrderByNomAnneeAccademique();
    }

    @GetMapping("/annee-accademiques/findByActifTrue")
    public AnneeAccademique findByActifTrue() {
        return anneeAccademiqueRepository.findByActifTrue();
    }

    @GetMapping("/annee-accademiques/findByannesuivant")
    public AnneeAccademique findByannesuivant() {
        return anneeAccademiqueRepository.findAllByOrderByNomAnneeAccademiqueDesc().get(0);
    }

   
}
