
export interface IParcours {
    id?: any;
    ecole?: string;
    diplome?: string;
    domaineEtude?: string;
    anneeDebut?: string;
    moisDebut?: string; 
    anneeFin?: string;
    moisFin?: string;
    date?: any
}

export class Parcours implements IParcours{
    constructor(
    public id?: any,
    public ecole?: string,
    public diplome?: string,
    public domaineEtude?: string,
    public anneeDebut?: string,
    public moisDebut?: string, 
    public anneeFin?: string,
    public moisFin?: string,
    public date?: any
    ){}
}