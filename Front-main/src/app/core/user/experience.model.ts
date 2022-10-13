
export interface IExperience{
    id?: any;
    intitulePoste?: string;
    typeEmploi?: string;
    nomEntreprise?: string;
    lieu?: string;
    moisDebut?: string;
    anneeDebut?: string;
    moisFin?: string;
    anneeFin?: string;
    secteur?: string;
    titreProfil?: string;
}
export class Experience implements IExperience{

    constructor(
        public id?: any,
        public intitulePoste?: string,
        public typeEmploi?: string,
        public nomEntreprise?: string,
        public lieu?: string,
        public moisDebut?: string,
        public anneeDebut?: string,
        public moisFin?: string,
        public anneeFin?: string,
        public secteur?: string,
        public titreProfil?: string
    ){}

}