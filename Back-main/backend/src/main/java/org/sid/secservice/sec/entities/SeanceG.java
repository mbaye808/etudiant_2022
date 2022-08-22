package org.sid.secservice.sec.entities;

public class SeanceG {
    
    private String heureDebut;
    private String heureFin;
    private Boolean etatSeance;
    private String online;
    private String salle;
    private String enseignant;
    private String membre;
    private String historiqueEnseignement;
    private String groupeTdTp;
    private String classe;

    
    public String getClasse() {
        return classe;
    }
    public void setClasse(String classe) {
        this.classe = classe;
    }
    
    public String getEnseignant() {
        return enseignant;
    }
    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }
    public String getHeureDebut() {
        return heureDebut;
    }
    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }
    public String getHeureFin() {
        return heureFin;
    }
    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
    public Boolean getEtatSeance() {
        return etatSeance;
    }
    public void setEtatSeance(Boolean etatSeance) {
        this.etatSeance = etatSeance;
    }
    public String getOnline() {
        return online;
    }
    public void setOnline(String online) {
        this.online = online;
    }
    public String getSalle() {
        return salle;
    }
    public void setSalle(String salle) {
        this.salle = salle;
    }
    public String getMembre() {
        return membre;
    }
    public void setMembre(String membre) {
        this.membre = membre;
    }
    public String getHistoriqueEnseignement() {
        return historiqueEnseignement;
    }
    public void setHistoriqueEnseignement(String historiqueEnseignement) {
        this.historiqueEnseignement = historiqueEnseignement;
    }
    public String getGroupeTdTp() {
        return groupeTdTp;
    }
    public void setGroupeTdTp(String groupeTdTp) {
        this.groupeTdTp = groupeTdTp;
    }

    
}
