
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Parcours } from 'app/core/user/alumni.model';
import { ReclamationService } from 'app/service/reclamation.service';

import * as moment from 'moment';

@Component({
    selector   : 'access-update',
    templateUrl: './access-update.component.html',
    styleUrls  : ['./access-update.component.scss']
})
export class AccessUpdateComponent implements OnInit
{

    alumni: Parcours
    alumniForm: FormGroup;
    isSave=false
    constructor(private router: Router, private service: ReclamationService,
       private _formBuilder: FormBuilder,
       private dialogRe: MatDialog){}

ngOnDestroy(): void {
   
    }

ngOnInit(): void {
    this.alumniForm = this._formBuilder.group({
        ecole: [
            '',
            [
              
            ],
          ],
        diplome: [
            '',
            [
            
            ],
          ],
        domaineEtude: [
            '',
            [
              
            ],
          ],
          anneeDebut: [
            '',
            [
              
            ],
          ],
        moisDebut: [
            '',
            [
              
            ],
          ],
        anneeFin: [
            '',
            [
              
            ],
          ],
        moisFin: [
            '',
            [
              
            ],
          ], 
    });
     console.log(this.alumni)
    if(this.alumni){
      this.alumniForm.patchValue({
        ecole:this.alumni.ecole,
        diplome:this.alumni.diplome,
        domaineEtude:this.alumni.domaineEtude,
        anneeDebut:this.alumni.anneeDebut,
        moisDebut:this.alumni.moisDebut,
        anneeFin:this.alumni.anneeFin,
        moisFin:this.alumni.moisFin,         

      })
    } 

  }
private createAlumni(): Parcours{
    return{
      ...new Parcours(),
      id: this.alumni.id,
      ecole: this.alumniForm.get(['ecole'])!.value,
      diplome: this.alumniForm.get(['diplome'])!.value,
      domaineEtude: this.alumniForm.get(['domaineEtude'])!.value,
      anneeDebut: this.alumniForm.get(['anneeDebut'])!.value,
      moisDebut: this.alumniForm.get(['moisDebut'])!.value,
      anneeFin: this.alumniForm.get(['anneeFin'])!.value,
      moisFin: this.alumniForm.get(['moisFin'])!.value, 
    }
  }
  onSubmit(){
    this.alumni=this.createAlumni();
    this.service.update2(this.alumni).subscribe(data =>{
      
      this.close()
    },);
    
  }
  close(): void{
  
    this.dialogRe.closeAll();
  }
}