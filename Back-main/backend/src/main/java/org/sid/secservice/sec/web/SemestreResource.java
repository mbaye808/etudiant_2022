package org.sid.secservice.sec.web;

import org.apache.tomcat.util.http.HeaderUtil;
import org.sid.secservice.sec.entities.HistoriqueUniteEnseignement;
import org.sid.secservice.sec.entities.Semestre;
import org.sid.secservice.sec.repo.AnneeAccademiqueRepository;
import org.sid.secservice.sec.repo.GroupeRepository;
import org.sid.secservice.sec.repo.HistoriqueUniteEnseignementRepository;
import org.sid.secservice.sec.repo.InscriptionRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;

/**
 * REST controller for managing {@link sn.esp.pgi.domain.Semestre}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SemestreResource {

    private final Logger log = LoggerFactory.getLogger(SemestreResource.class);
    private static final String ENTITY_NAME = "semestre";
    /*
     * @Value("${jhipster.clientApp.name}")
     * private String applicationName;
     */

    // private final SemestreRepository semestreRepository;
    @Autowired
    private GroupeRepository groupeRepository;
    @Autowired
    private HistoriqueUniteEnseignementRepository historiqueUniteEnseignementRepository;

    @GetMapping("/semestres/getSemestresbyNiveau/{idgroupe}")
    public List<Semestre> getSemestresbyNiveau(@PathVariable Long idgroupe) {
        log.debug("REST request to get a page of Semestres");
        List<Semestre> semestres = new ArrayList<>();
        for (HistoriqueUniteEnseignement historiqueUniteEnseignement : historiqueUniteEnseignementRepository
                .findByUniteEnseignementNiveauAndAnneeAccademiqueActifTrueAndIsExecuteTrueOrderByNewCode(
                        groupeRepository.findById(idgroupe).get().getNiveau())) {
            if (!semestres.contains(historiqueUniteEnseignement.getSemestre())) {
                semestres.add(historiqueUniteEnseignement.getSemestre());
            }
        }
        return semestres;
    }

    /*
     * @GetMapping("/semestres/semestre/{idanne}/{idgroupe}/{iddecision}")
     * public Semestre getSemestreSemestre(@PathVariable Long idanne,@PathVariable
     * Long idgroupe,@PathVariable Long iddecision) {
     * 
     * return
     * exportBulletinService.getSemestre(anneeAccademiqueRepository.getOne(idanne),
     * groupeRepository.getOne(idgroupe).getNiveau(),decisionRepository.getOne(
     * iddecision));
     * }
     */
}
