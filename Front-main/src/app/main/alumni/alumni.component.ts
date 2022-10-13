

import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { AccountService } from 'app/core/auth/account.service';
import { Parcours } from 'app/core/user/alumni.model';
import { Experience } from 'app/core/user/experience.model';
import { ReclamationService } from 'app/service/reclamation.service';
import { RegisterService } from 'app/service/register.service';
import {fuseAnimations} from '../../../@fuse/animations';
import { AccesComponent } from '../acces/acces.component';
import { AccessUpdateComponent } from '../access-update/access-update.component';
import { ExperienceUpdateComponent } from '../experience-update/experience-update.component';
import { ExperienceComponent } from '../experience/experience.component';

@Component({
  selector: 'app-alumni',
  templateUrl: './alumni.component.html',
  styleUrls: ['./alumni.component.scss'],
  animations : fuseAnimations
})
export class AlumniComponent implements OnInit {
   

  parcours: Parcours[]
  experiences: Experience[]
  constructor(private dialogRes: MatDialog,
    private _service: ReclamationService,
    private _account: AccountService,
    private service: RegisterService,
    private route: ActivatedRoute) {

  }
  varAlumni: any;
  ngOnInit(): void {
    console.log("ffffffffffffffffffffffffff");
    this._account.userConnecter().subscribe((res)=>{
      this.varAlumni=res;
    });
    
    this.getParcours();

    this.getExperience();
  }
  private getParcours(){
    this.service.getParcoursList().subscribe(data =>{
      this.parcours = data;
    })
  }
  private getExperience(){
    this.service.getExperienceList().subscribe(data =>{
      this.experiences = data;
    })
  }

  openDialogue(){
    this.dialogRes.open(AccesComponent, {
      height:'500px' ,
      width:'750px',
     // maxHeight: '630px',
      position: { top: "10px", right:"130px"},
      disableClose: true
  });
  }
  openDialogue2(parcour){
   const dialog = this.dialogRes.open(AccessUpdateComponent, {
      height:'500px' ,
      width:'750px',
      maxHeight: '730px',
      position: { top: "10px", right:"130px"},
      disableClose: true
  });
  dialog.componentInstance.alumni=parcour;
  }
  openDialogue3(){
    this.dialogRes.open(ExperienceComponent, {
      height:'500px' ,
      width:'750px',
     // maxHeight: '630px',
      position: { top: "10px", right:"130px"},
      disableClose: true
  });
  }
  openDialogue4(experience){
    const dialog = this.dialogRes.open(ExperienceUpdateComponent, {
       height:'500px' ,
       width:'750px',
       position: { top: "10px", right:"130px"},
       disableClose: true
   });
   dialog.componentInstance.alumni=experience;
   }

  alumniUser(ine:any){
    this._service.getAlumniByIne(ine).subscribe((res)=>{
      console.log(res);
    })
  }
}