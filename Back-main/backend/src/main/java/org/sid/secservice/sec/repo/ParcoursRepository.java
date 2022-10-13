package org.sid.secservice.sec.repo;

import java.util.List;

import org.sid.secservice.sec.entities.Parcours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcoursRepository extends JpaRepository<Parcours, Long>{

    List<Parcours> findByEtudiantIne(String ine);

    List<Parcours> findByIne(String ine);
}
