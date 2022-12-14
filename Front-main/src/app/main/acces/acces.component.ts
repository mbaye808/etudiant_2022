
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Parcours } from 'app/core/user/alumni.model';
import { RegisterService } from 'app/service/register.service';

import * as moment from 'moment';

@Component({
    selector   : 'acces',
    templateUrl: './acces.component.html',
    styleUrls  : ['./acces.component.scss']
})
export class AccesComponent implements OnInit
{

    alumni: Parcours = new Parcours();
    alumniForm: FormGroup;
    isSave=false
    constructor(private router: Router, private service: RegisterService,
       private _formBuilder: FormBuilder,
       private dialogRe: MatDialog){}

ngOnDestroy(): void {
   
    }

ngOnInit(): void {
    this.alumniForm = this._formBuilder.group({
        ecole: [
            '',
            [
              Validators.required,
            ],
          ],
        diplome: [
            '',
            [
              Validators.required,
            ],
          ],
        domaineEtude: [
            '',
            [
              Validators.required,
            ],
          ],
         anneeDebut: [
            '',
            [
              Validators.required,
            ],
          ],
        moisDebut: [
            '',
            [
              Validators.required,
            ],
          ], 
          anneeFin: [
            '',
            [
              Validators.required,
            ],
          ],
        moisFin: [
            '',
            [
              Validators.required,
            ],
          ], 
    });
    
}


private createAlumni(): Parcours{
    return{
      ...new Parcours(),
      id: null,
      ecole: this.alumniForm.get(['ecole'])!.value,
      diplome: this.alumniForm.get(['diplome'])!.value,
      domaineEtude: this.alumniForm.get(['domaineEtude'])!.value,
      anneeDebut: this.alumniForm.get(['anneeDebut'])!.value,
      moisDebut: this.alumniForm.get(['moisDebut'])!.value,
      anneeFin: this.alumniForm.get(['anneeFin'])!.value,
      moisFin: this.alumniForm.get(['moisFin'])!.value, 
    }
  }
saveAlumni(){

    this.alumni=this.createAlumni();
    this.isSave=true
    console.log(this.alumni)
    this.service.registerAlumni(this.alumni).subscribe(
      data => {
      alert("Informations enregistr??es");
      
  
    },
    error => {
      this.isSave=false
      alert("echec, verifier vos information");
  },()=>  {this.router.navigate(['/alumni']);this.isSave=false}) 
} 
closes(): void{

  this.dialogRe.closeAll();

}
}