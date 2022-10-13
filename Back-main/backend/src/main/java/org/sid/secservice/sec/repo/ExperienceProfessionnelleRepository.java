package org.sid.secservice.sec.repo;

import java.util.List;

import org.sid.secservice.sec.entities.ExperienceProfessionnelle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceProfessionnelleRepository extends JpaRepository<ExperienceProfessionnelle, Long>{
    
    List<ExperienceProfessionnelle> findByIne(String ine);
}
