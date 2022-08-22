package org.sid.secservice.sec.repo;


import org.springframework.stereotype.Repository;

import org.sid.secservice.sec.entities.Session;
import org.sid.secservice.sec.entities.enumeration.EnumSession;
import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Session entity.
 */
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Session findBySession(EnumSession enumSession);

}
