package org.sid.secservice.sec.service;

import org.sid.secservice.sec.entities.Membre;
import org.sid.secservice.sec.repo.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MembreService {
    @Autowired
    private MembreRepository membreRepository;

    /* public boolean isMembre(Structure structure){
        String username = SecurityUtils.getCurrentUserLogin().get();
        if(userRepository.findOneWithAuthoritiesByLogin(username).isPresent() && (userRepository.findOneWithAuthoritiesByLogin(username).get().getAuthorities().contains(AuthoritiesConstants.ADMINETABLISSEMENT) || userRepository.findOneWithAuthoritiesByLogin(username).get().getAuthorities().contains(AuthoritiesConstants.CHEFSCORALITE) || userRepository.findOneWithAuthoritiesByLogin(username).get().getAuthorities().contains(AuthoritiesConstants.AGENTSCOLARITE)))
            return true;
        else{
            if(structure.equals(this.getMembreCurrent().getStructure()))
                return true;
            return true;
        }
    } */
}
