import { HttpResponse } from '@angular/common/http';

import { AnneeAcademiqueService } from './../../service/annee-academique.service';
import { Classe, IClasse } from './../../shared/model/classe.model';
import { AnneeAcademique, IAnneeAcademique } from './../../shared/model/annee-academique.model';
import { Inscription } from './../../shared/model/inscription.model';
import { Semestre, ISemestre } from './../../shared/model/semestre.model';
import { Note } from './../../shared/model/note.model';
import { Component, OnInit } from '@angular/core';

import { FuseTranslationLoaderService } from '@fuse/services/translation-loader.service';
 
import { locale as english } from './i18n/en';
import { locale as turkish } from './i18n/tr';
import { SemestreService } from '../../service/semestre.service';
import { ClasseService } from '../../service/classe.service';
import { MatDialog } from '@angular/material/dialog';

import { Reclamation } from '../../shared/model/reclamation.model';
import * as moment from 'moment';
import { ContactsContactFormDialogComponent } from './contact-form/contact-form.component';
import { Account } from 'app/core/user/account.model';
import { User } from 'app/core/user/user.model';
import { AccountService } from 'app/core/auth/account.service';
import { ReclamationComponent } from '../reclamation/reclamation.component';
import { exit } from 'process';

@Component({
    selector   : 'sample',
    templateUrl: './sample.component.html',
    styleUrls  : ['./sample.component.scss']
})
export class SampleComponent implements OnInit
{
    notes:any;
     notes2:Note[];
     okey:boolean = false;
     semestre:any
    semestres:Semestre[]
    classe: Classe;
    classes: Classe[]
    session: any
    sessions: any
    anneeAccademique: AnneeAcademique
    account: User
    anneeAccademiques: AnneeAcademique[]
    dialogRef: any;
    
    /**
     * Constructor
     *
     * @param {FuseTranslationLoaderService} _fuseTranslationLoaderService
     */
   
    constructor(
        private _fuseTranslationLoaderService: FuseTranslationLoaderService, protected anneeAcademiqueService: AnneeAcademiqueService, protected semestreService: SemestreService,
        protected classeEt: ClasseService,private _matDialog: MatDialog,
        private accountService: AccountService, private dialogRe: MatDialog
    )
    {
        this._fuseTranslationLoaderService.loadTranslations(english, turkish);
    }
    newContact(ec:any, note:any): void 
    { 

        const dialogRef = this._matDialog.open(ContactsContactFormDialogComponent, 
            {
            panelClass: 'contact-form-dialog',
            data      : {
                action: 'new'
            }
        });
        dialogRef.componentInstance.reclamation={id:null,enseignement:"",noteReclamation:null}
        dialogRef.componentInstance.ec=ec;
        let reclamation = new Reclamation();
      
        reclamation.etat= "En_cours"
        dialogRef.componentInstance.reclamation=reclamation;
    }
    ngOnInit() {
        //this.anneeAcademiqueService.query().subscribe((res: HttpResponse<IAnneeAcademique[]>) => (this.anneeAccademiques = res.body || []));
       // this.semestreService.session().subscribe((res: HttpResponse<ISemestre[]>) => (this.sessions = res.body || []));
      
       this.accountService.userConnecter().subscribe((account)=>{
        this.account=account;
        this.getGroupeEtudiant();
        this.semestreService.session().subscribe((res: HttpResponse<any[]>) => {this.sessions = res.body || [] , console.log(this.sessions)});
    })
    }
    getGroupeEtudiant(){
        // this.accountService.userConnecter().subscribe((account)=>{
        // this.account=account
            this.classeEt.getClasse().subscribe((res: HttpResponse<IClasse[]>) => {this.classes = res.body || [] , console.log(this.classes)});            
    }
    getSemestres(){
        this.notes=[]
        this.semestreService.getSemestre(this.classe.id).subscribe((res: HttpResponse<ISemestre[]>) => (this.semestres = res.body || []));
    }
    getNotes(){
        this.notes=[]
        this.semestreService.getsNote(this.classe.id,this.semestre.id,this.session.id).subscribe((res: HttpResponse<ISemestre[]>) =>{
            this.notes = res.body ;
            console.log(res.body)
        } ); 
    }
    openDialog(historiqueElementContitutif){
        let dialog=this.dialogRe.open(ReclamationComponent, {
            height:'480px' ,
            width:'550px',
            maxHeight: '360px',
            position: { top: "10px" },
            disableClose: true
        });
        dialog.componentInstance.semestre=this.semestre
        dialog.componentInstance.session=this.session
        dialog.componentInstance.classe=this.classe
        dialog.componentInstance.historiqueElementContitutif=historiqueElementContitutif
    }
    
}
  