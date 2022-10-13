
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Experience } from 'app/core/user/experience.model';
import { ReclamationService } from 'app/service/reclamation.service';
import { RegisterService } from 'app/service/register.service';


import * as moment from 'moment';

@Component({
    selector   : 'experience-update',
    templateUrl: './experience-update.component.html',
    styleUrls  : ['./experience-update.component.scss']
})
export class ExperienceUpdateComponent implements OnInit
{

    alumni: Experience = new Experience();
    alumniForm: FormGroup;
    isSave=false

    constructor(private router: Router,
         private service: RegisterService,
         private _service: ReclamationService,
          private _formBuilder: FormBuilder,
          private dialogRe: MatDialog){}
  

ngOnDestroy(): void {
   
    }

ngOnInit(): void {
    this.alumniForm = this._formBuilder.group({
        intitulePoste: [
            '',
            [
              
            ],
          ],
        typeEmploi: [
            '',
            [
              
            ],
          ],
        nomEntreprise: [
            '',
            [
              
            ],
          ],
        lieu: [
            '',
            [
              
            ],
          ],
        moisDebut: [
            '',
            [
              
            ],
          ],
        anneeDebut: [
            '',
            [
              
            ],
          ],
        moisFin: [
            '',
            [
              
            ],
          ],
          anneeFin: [
            '',
            [
              
            ],
          ],
        secteur: [
            '',
            [
             
            ],
          ],
          titreProfil: [
            '',
            [
              
            ],
          ],
    });
    console.log(this.alumni)
    if(this.alumni){
      this.alumniForm.patchValue({
        intitulePoste:this.alumni.intitulePoste,
        typeEmploi:this.alumni.typeEmploi,
        nomEntreprise:this.alumni.nomEntreprise,
        lieu:this.alumni.lieu,
        anneeDebut:this.alumni.anneeDebut,
        moisDebut:this.alumni.moisDebut,
        anneeFin:this.alumni.anneeFin,
        moisFin:this.alumni.moisFin, 
        secteur:this.alumni.secteur,
        titreProfil:this.alumni.titreProfil,        

      })
    } 
}
private createAlumni(): Experience{
    return{
      ...new Experience(),
      id: this.alumni.id,
      intitulePoste: this.alumniForm.get(['intitulePoste'])!.value,
      typeEmploi: this.alumniForm.get(['typeEmploi'])!.value,
      nomEntreprise: this.alumniForm.get(['nomEntreprise'])!.value,
      lieu: this.alumniForm.get(['lieu'])!.value,
      moisDebut: this.alumniForm.get(['moisDebut'])!.value,
      anneeDebut: this.alumniForm.get(['anneeDebut'])!.value,
      moisFin: this.alumniForm.get(['moisFin'])!.value,
      anneeFin: this.alumniForm.get(['anneeFin'])!.value,
      secteur: this.alumniForm.get(['secteur'])!.value,
      titreProfil: this.alumniForm.get(['titreProfil'])!.value,
}
}
onSubmit(){
    this.alumni=this.createAlumni();
    this._service.update3(this.alumni).subscribe(data =>{
      
      this.close()
    },);
    
  }
  close(): void{
  
    this.dialogRe.closeAll();
  }
}