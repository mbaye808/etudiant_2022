package org.sid.secservice.sec.web;

import org.sid.secservice.sec.entities.BulletinProvisoirExport;
import org.sid.secservice.sec.service.ExportBulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Transactional
public class NoteRessource {

    @Autowired
    private AccountRestController accountRestController;
    @Autowired
    private ExportBulletinService bulletinService ;

     @GetMapping("/notes/getNotesByUniteEnseignement/{idgroupe}/{idSemestre}/{idSession}")
    public BulletinProvisoirExport getNoteByEcUe(@PathVariable Long idgroupe,@PathVariable Long idSemestre,@PathVariable Long idSession) {
        return this.bulletinService.getDonneExport(idgroupe,idSemestre, idSession, accountRestController.userConnecter().get().getIne());
        
    }
    
}


