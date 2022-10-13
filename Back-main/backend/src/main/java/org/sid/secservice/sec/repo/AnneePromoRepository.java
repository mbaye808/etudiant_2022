package org.sid.secservice.sec.repo;

import org.sid.secservice.sec.entities.AnneePromo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneePromoRepository extends JpaRepository<AnneePromo, Long>{
    
}
