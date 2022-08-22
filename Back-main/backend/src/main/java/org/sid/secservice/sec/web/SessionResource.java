package org.sid.secservice.sec.web;

import org.sid.secservice.sec.entities.Session;
import org.sid.secservice.sec.repo.SessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing {@link sn.esp.pgi.domain.Session}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SessionResource {

    private final Logger log = LoggerFactory.getLogger(SessionResource.class);

    private static final String ENTITY_NAME = "session";

    // @Value("${jhipster.clientApp.name}")
    // private String applicationName;

    private final SessionRepository sessionRepository;
  
    public SessionResource(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    /**
     * {@code GET  /sessions} : get all the sessions.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sessions in body.
     */
    @GetMapping("/sessions")
    public List<Session> getAllSessions() {
        log.debug("REST request to get all Sessions");
        return sessionRepository.findAll();
    }
}
