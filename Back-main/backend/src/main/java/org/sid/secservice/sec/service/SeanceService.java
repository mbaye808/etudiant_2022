package org.sid.secservice.sec.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sid.secservice.sec.entities.GroupeTdTp;
import org.sid.secservice.sec.entities.HistoriqueEnseignement;
import org.sid.secservice.sec.entities.Salle;
import org.sid.secservice.sec.entities.Seance;
import org.sid.secservice.sec.entities.SeanceGroupe;
import org.sid.secservice.sec.repo.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;


    public Boolean salleDisponible(ZonedDateTime debut,ZonedDateTime fin,Salle salle){
        List<Seance>  seances=this.seanceRepository.findBysalle(debut, fin,salle);
        if(seances.size()==0)
            return false;
        return true;
    }

    public Map<String,Float> statistiqueSeance(List<SeanceGroupe> seanceGroupes,Integer sum){

        Map<String,Float> seanceStatistiques=new HashMap<>();
        float heureeffectue=0;
        float heurePlannier=0;
        float heureeheurePlannierNonFait=0;
        for (SeanceGroupe seance : seanceGroupes) {
            if(Boolean.TRUE.equals(seance.getSeance().isEtatSeance().booleanValue()))
                heureeffectue+=seanceHeure(seance.getSeance());
            heurePlannier+=seanceHeure(seance.getSeance());
            if((!Boolean.TRUE.equals(seance.getSeance().isEtatSeance().booleanValue())) && Boolean.TRUE.equals(seance.getSeance().getPlanning().isEtat())){
                heureeheurePlannierNonFait+=seanceHeure(seance.getSeance());;
            }
        }
        seanceStatistiques.put("heureeffectue", heureeffectue);
        if(sum!=null)
            seanceStatistiques.put("prevu", sum.floatValue());
        else
            seanceStatistiques.put("prevu", 0f);
        seanceStatistiques.put("heurePlannier", heurePlannier);
        seanceStatistiques.put("heureeheurePlannierNonFait", (heureeheurePlannierNonFait));
        return seanceStatistiques;
    }
    public Map<Long,List<SeanceGroupe>> statistiqueSeanceDepartement(List<SeanceGroupe> seanceGroupes){
        Map<Long,List<SeanceGroupe>> seanceStatistiques=new HashMap<>();
        for (SeanceGroupe seance : seanceGroupes) {
            if(!seanceStatistiques.containsKey(seance.getGroupe().getId())){
                List<SeanceGroupe> seanceGroupe=new ArrayList();
                seanceGroupe.add(seance);
                seanceStatistiques.put(seance.getGroupe().getId(), seanceGroupe);
            }else{
                seanceStatistiques.get(seance.getGroupe().getId()).add(seance);
            }
        }
        return seanceStatistiques;
    }
    public Map<Long,Integer> volumeHoraire(List<HistoriqueEnseignement> historiqueEnseignements){
        Map<Long,Integer> seanceStatistiques=new HashMap<>();
        for (HistoriqueEnseignement historiqueEnseignement : historiqueEnseignements) {
            Long key =historiqueEnseignement.getHistoriqueElementContitutif().getHistoriqueUniteEnseignement().getUniteEnseignement().getNiveau().getId();
            if(!seanceStatistiques.containsKey(key)){
                seanceStatistiques.put(key, historiqueEnseignement.getVolumeHoraire());
            }else{
                Integer vh= seanceStatistiques.get(key)+historiqueEnseignement.getVolumeHoraire();
                seanceStatistiques.put(key, vh);
            }
          
        }
        return seanceStatistiques;
    }
    public Seance seanceEat(Seance seance,boolean etat){
        if(etat && seance.isEtatSeance().booleanValue() )
            return seance;
        else{
            if( Boolean.TRUE.equals(seance.getPlanning().isEtat()) &&!Boolean.TRUE.equals(seance.isEtatSeance())){
                return seance;
            }
        }
        return null;
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
    public Float seanceHeure(Seance seance){
        return (seance.getHeureFin().getHour()-seance.getHeureDebut().getHour())  +(seance.getHeureFin().getMinute()-seance.getHeureDebut().getMinute())/60f;
    }

    Float sumVH( List<HistoriqueEnseignement> historiqueEnseignements,List<GroupeTdTp> groupeTdTps){
       return (float) historiqueEnseignements.stream().map(x-> x.getVolumeHoraire()*nombreGroupeTdTp(groupeTdTps, x)).mapToDouble(Double::doubleValue).sum();
    }
    
    double nombreGroupeTdTp( List<GroupeTdTp> groupeTdTps,HistoriqueEnseignement historiqueEnseignement){
        double nonmbre= groupeTdTps.stream().filter(x->x.getHistoriqueEnseignements().contains(historiqueEnseignement)).count();
        return nonmbre!=0 ? nonmbre:1;
    }
}
