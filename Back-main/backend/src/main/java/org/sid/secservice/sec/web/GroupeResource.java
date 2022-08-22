package org.sid.secservice.sec.web;


import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.Niveau;
import org.sid.secservice.sec.repo.GroupeRepository;
import org.sid.secservice.sec.repo.NiveauRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * REST controller for managing {@link sn.esp.pgi.domain.Groupe}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class GroupeResource {

    private final Logger log = LoggerFactory.getLogger(GroupeResource.class);

    private static final String ENTITY_NAME = "groupe";
    private final GroupeRepository groupeRepository;
    @Autowired
    private  NiveauRepository niveauRepository;

    
    // @Value("${jhipster.clientApp.name}")
    // private String applicationName;


    public GroupeResource(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    /**
     * {@code GET  /groupes/:id} : get the "id" groupe.
     *
     * @param id the id of the groupe to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the groupe, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/groupes/{id}")
    public Optional<Groupe> getGroupe(@PathVariable Long id) {
        log.debug("REST request to get Groupe : {}", id);
        Optional<Groupe> groupe = groupeRepository.findById(id);
        return groupe;
    }

    
    @GetMapping("/groupes/findByNiveau/{id}")
    public List<Groupe> getGroupeByNiveau(@PathVariable Long id) {
        log.debug("REST request to get GroupeByNiveau: {}", id);
        Niveau niveau = niveauRepository.getOne(id);
        return groupeRepository.findByNiveau(niveau);
    }
   
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/groupes/findByGroupeResponsable/")
    public List<Groupe> findByGroupeResponsable(@PathVariable Long id) {
        log.debug("REST request to get GroupeByNiveau: {}", id);
        Niveau niveau = niveauRepository.getOne(id);
        return groupeRepository.findByNiveau(niveau);
    }
   
    
    
    @GetMapping("/groupes/findByCode")
    public Groupe getGroupeByCode(@RequestParam String code) {
        return groupeRepository.findByCode(code);
    }
    
/*     @GetMapping("/groupes/exportListEtudiant/{id}")

    public byte[] exportListEtudiant(@PathVariable Long id, HttpServletResponse response) {

        InputStream jasperStream = this.getClass().getResourceAsStream("/report/etudians.jrxml");
        EtudiantExport etudiantExport = new EtudiantExport();
        Groupe groupe = groupeRepository.getOne(id);
        ArrayList<EtudiantDetailExport> etudiantDetailExports = new ArrayList<EtudiantDetailExport>();
        List<Inscription> inscriptions = inscriptionRepository.findByGroupeAndAnneeAccademiqueActifTrue(groupe);
        for (Inscription inscription : inscriptions) {
            EtudiantDetailExport etudiantDetailExport = new EtudiantDetailExport();
            etudiantDetailExport.setIne(inscription.getEtudiant().getIne());
            etudiantDetailExport.setNom(inscription.getEtudiant().getNom());
            etudiantDetailExport.setPrenom(inscription.getEtudiant().getPrenom());
            etudiantDetailExport.setTelephone(inscription.getEtudiant().getTelephone());
            etudiantDetailExport.setDateNaissance(inscription.getEtudiant().getDateNaissance().toString());
            etudiantDetailExport.setLieuNaissance(inscription.getEtudiant().getLieuNaissance());
            etudiantDetailExport.setEmail(inscription.getEtudiant().getAdresse());
            etudiantDetailExport.setCin(inscription.getEtudiant().getCin());
            etudiantDetailExports.add(etudiantDetailExport);
        }
        etudiantExport.setEtudiants(etudiantDetailExports);
        etudiantExport.setGroupe(groupe.getCode());
        List datas = new ArrayList();
        datas.add(0, etudiantExport);
        response.setContentType("application/octet-stream");
        return exportService.exportXLS(jasperStream, datas);
    } */


}
