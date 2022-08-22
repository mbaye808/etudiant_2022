package org.sid.secservice.sec.web;

import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.Membre;
import org.sid.secservice.sec.entities.Niveau;
import org.sid.secservice.sec.entities.Seance;
import org.sid.secservice.sec.entities.SeanceG;
import org.sid.secservice.sec.entities.SeanceGroupe;
import org.sid.secservice.sec.repo.AnneeAccademiqueRepository;
import org.sid.secservice.sec.repo.GroupeRepository;
import org.sid.secservice.sec.repo.HistoriqueEnseignementRepository;
import org.sid.secservice.sec.repo.InscriptionRepository;
import org.sid.secservice.sec.repo.MembreRepository;
import org.sid.secservice.sec.repo.NiveauRepository;
import org.sid.secservice.sec.repo.PlanningRepository;
import org.sid.secservice.sec.repo.SalleRepository;
import org.sid.secservice.sec.repo.SeanceGroupeRepository;
import org.sid.secservice.sec.repo.SeanceRepository;
import org.sid.secservice.sec.repo.SemestreRepository;
import org.sid.secservice.sec.service.AccountServiceImpl;
import org.sid.secservice.sec.service.MembreService;
import org.sid.secservice.sec.service.SeanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;


/**
 * REST controller for managing {@link sn.esp.pgi.domain.Seance}.
 */
@RestController
@RequestMapping("/api")

public class SeanceResource {

    private final Logger log = LoggerFactory.getLogger(SeanceResource.class);

    private static final String ENTITY_NAME = "seance";

    private final SeanceRepository seanceRepository;

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @Autowired
    private SeanceGroupeRepository seanceGroupeRepository;

    @Autowired
    private InscriptionRepository inscriptionRepository;
 
    @Autowired
    private MembreRepository membreRepository;

    public SeanceResource(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }
    @GetMapping("/seances/findByNiveau/{date}")
    public List<SeanceG> getSeanceByNiveau(@PathVariable String date) {
        System.out.println(date);
        log.debug("REST request to get SeanceByNiveau: {}", date);
        LocalDate localDate=LocalDate.of(Integer.parseInt( date.split("-")[0]), Integer.parseInt( date.split("-")[1]), Integer.parseInt( date.split("-")[2]));
        List<SeanceG> seances = new ArrayList<>();
        Optional<AppUser> appUser = accountServiceImpl.getUserWithAuthorities();
        final Date thisday = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        final String _semaineDebut = new SimpleDateFormat("dd/MM/yyyy").format(this.firstDayOfMonth(thisday)); // jour de fin de la semaine
        final String _semaineFin =  new SimpleDateFormat("dd/MM/yyyy").format(this.lastDayOfMonth(thisday));
        final LocalDate dateDebut = LocalDate.parse(_semaineDebut, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        final LocalDate dateFin = LocalDate.parse(_semaineFin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        ZonedDateTime tdebut = ZonedDateTime.of(dateDebut,LocalTime.of(7,0), ZoneId.of("UTC"));
        ZonedDateTime tfin = ZonedDateTime.of(dateFin,LocalTime.of(23,0), ZoneId.of("UTC"));
        System.out.println(this.membreRepository.findAll()+"vvvbbbbbb");
        for (Membre var : this.membreRepository.findAll()) {
            System.out.println(var);
            var.setNom(var.getUser().getLastName());
            var.setPrenom(var.getUser().getFirstName());
            this.membreRepository.save(var);
        }
        List<SeanceGroupe> seanceGsGroupes=new ArrayList<>();
        List<Groupe> groupes=inscriptionRepository.findByEtudiantIneAndAnneeAccademiqueActifTrue(appUser.get().getIne());
        for (Groupe var : groupes) {
            for (SeanceGroupe seanceGroupe : seanceGroupeRepository.findByGroupeAndSeanceHeureDebutAfterAndSeanceHeureDebutBefore(var,tdebut,tfin)) {
                SeanceG seanceG =new SeanceG();
                seanceG.setHeureDebut(seanceGroupe.getSeance().getHeureDebut().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
                seanceG.setHeureFin(seanceGroupe.getSeance().getHeureFin().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
                seanceG.setHistoriqueEnseignement(seanceGroupe.getSeance().getHistoriqueEnseignement().getIntitule());
                seanceG.setOnline(seanceGroupe.getSeance().getOnline());
                seanceG.setClasse(seanceGroupe.getGroupe().getLibelle());
                if(seanceGroupe.getSeance().getSalle()!=null)
                    seanceG.setSalle(seanceGroupe.getSeance().getSalle().getNom());
                if(seanceGroupe.getSeance().getMembre()!=null)
                    seanceG.setEnseignant(" Mr/Mme " +seanceGroupe.getSeance().getMembre().getPrenom()+"  "+seanceGroupe.getSeance().getMembre().getNom());
                    seanceG.setMembre(seanceGroupe.getSeance().getMembre().getPrenom());
                if(seanceGroupe.getSeance().getGroupeTdTp()!=null)
                    seanceG.setGroupeTdTp(seanceGroupe.getSeance().getGroupeTdTp().getLibelle());
                seances.add(seanceG);
            }
           
        } 
        System.out.println(seanceGsGroupes);
        return seances;
    }
    public java.util.Date firstDayOfMonth(final Date thisday) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(thisday);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }
    public java.util.Date lastDayOfMonth(final Date thisday) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(thisday);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return cal.getTime();
    }   
}
