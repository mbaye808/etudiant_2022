package org.sid.secservice.sec.repo;

import java.util.Optional;

import org.sid.secservice.sec.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	// méthode permettant de retourner le Username
	
	// AppUser findByUsername(String username);

	Optional<Etudiant> findByIne(String idf);

	Optional<Etudiant> findByNom(String tempNom);

}
