package org.sid.secservice.sec.service;

import org.sid.secservice.sec.entities.GroupeTdTp;
import org.sid.secservice.sec.repo.GroupeTdTpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link GroupeTdTp}.
 */
@Service
@Transactional
public class GroupeTdTpService {

    private final Logger log = LoggerFactory.getLogger(GroupeTdTpService.class);

    private final GroupeTdTpRepository groupeTdTpRepository;
    
    public GroupeTdTpService(GroupeTdTpRepository groupeTdTpRepository) {
        this.groupeTdTpRepository = groupeTdTpRepository;
    }

    /**
     * Save a groupeTdTp.
     *
     * @param groupeTdTp the entity to save.
     * @return the persisted entity.
     */
    public GroupeTdTp save(GroupeTdTp groupeTdTp) {
        log.debug("Request to save GroupeTdTp : {}", groupeTdTp);
        return groupeTdTpRepository.save(groupeTdTp);
    }

   
}
