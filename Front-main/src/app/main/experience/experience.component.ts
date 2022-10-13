
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { Experience } from 'app/core/user/experience.model';
import { RegisterService } from 'app/service/register.service';

@Component({
    selector   : 'experience',
    templateUrl: './experience.component.html',
    styleUrls  : ['./experience.component.scss']
})
export class ExperienceComponent implements OnInit
{

    alumni: Experience = new Experience();
    alumniForm: FormGroup;
    isSave=false

    constructor(private router: Router,
         private service: RegisterService,
          private _formBuilder: FormBuilder,
          private dialogRe: MatDialog){}
ngOnDestroy(): void {
   
    }

ngOnInit(): void{
    this.alumniForm = this._formBuilder.group({
        intitulePoste: [
            '',
            [
              Validators.required,
            ],
          ],
        typeEmploi: [
            '',
            [
              Validators.required,
            ],
          ],
        nomEntreprise: [
            '',
            [
              Validators.required,
            ],
          ],
        lieu: [
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
        anneeDebut: [
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
          anneeFin: [
            '',
            [
              Validators.required,
            ],
          ],
        secteur: [
            '',
            [
              Validators.required,
            ],
          ],
          titreProfil: [
            '',
            [
              Validators.required,
            ],
          ],
    });
}
private createAlumni2(): Experience{
    return{
      ...new Experience(),
      id: null,
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
saveAlumni2(){
    this.alumni=this.createAlumni2();
    this.isSave=true
    this.service.registerAlumni2(this.alumni).subscribe(
      data => {
      alert("Informations enregistrées");
  
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