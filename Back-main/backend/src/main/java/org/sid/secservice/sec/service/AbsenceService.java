package org.sid.secservice.sec.service;

import org.sid.secservice.sec.entities.Absence;
import org.sid.secservice.sec.repo.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbsenceService {
    @Autowired
    private AbsenceRepository absenceRepository;

    public Integer getAbsenceUe(Long idInscription, Long idUniteEnseignement){
        Absence absence=this.absenceRepository.findByIdInscriptionAndIdUe( idInscription, idUniteEnseignement);
        if(absence!=null)
            return absence.getNombreAbsence();
        return 0;
    }

}
