package org.sid.secservice.sec.service;

import org.sid.secservice.sec.entities.ParametreRepechage;
import org.sid.secservice.sec.repo.ParametreRepechageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link ParametreRepechage}.
 */
@Service
@Transactional
public class ParametreRepechageService {

    private final Logger log = LoggerFactory.getLogger(ParametreRepechageService.class);

    private final ParametreRepechageRepository parametreRepechageRepository;


    public ParametreRepechageService(ParametreRepechageRepository parametreRepechageRepository) {
        this.parametreRepechageRepository = parametreRepechageRepository;
    }





        /**
     * Get liste  parametreRepechage by structure.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public ParametreRepechage StructureAndAnneeAcademique(Long id,Long idstructure) {
        log.debug("Request to get ParametreRepechage : {}", id);
        return parametreRepechageRepository.findByAnneeAccademiqueIdAndStructureId(id,idstructure);
    }

}
