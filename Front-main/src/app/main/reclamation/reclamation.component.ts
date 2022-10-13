import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ReclamationService } from 'app/service/reclamation.service';
import { Reclamation } from 'app/shared/model/reclamation.model';
import * as moment from 'moment';
import { JhiDataUtils, JhiEventWithContent, JhiFileLoadError } from 'ng-jhipster';

@Component({
    selector   : 'reclamation',
    templateUrl: './reclamation.component.html',
    styleUrls  : ['./reclamation.component.scss']
})
export class ReclamationComponent implements OnInit
{

  @ViewChild("fileUpload", {static: false}) fileUpload: ElementRef;files  = [];  
    reclamation = new Reclamation();

    reclamationForm: FormGroup;
    session:any;
    semestre:any
    historiqueElementContitutif: any;
    eventManager: any;
    classe: import("c:/Users/IBRAHIMA DABO/Desktop/sec-service/Front-main/src/app/shared/model/classe.model").Classe;
    //date =new Date(Date.now());

    constructor(private dialogRe: MatDialog, 
      private _formBuilder: FormBuilder, 
      private _service: ReclamationService,
      private dataUtils:JhiDataUtils, 
      private _router : Router){}

ngOnDestroy(): void {
   
    }

ngOnInit(): void {

    this.reclamationForm = this._formBuilder.group({

        typeReclamation: [
            '',
            [
              Validators.required,
            ],
          ],

          etat: [
            '',
          ],

          description: [
            '',
            [
              Validators.required,
            ],
          ],
          photo: [
            '',
          ],
          photoContentType: [
            '',
          ],
    });
}

private createReclamation(): Reclamation{
    return{
      ...new Reclamation(),
      id: null,
      typeReclamation: this.reclamationForm.get(['typeReclamation'])!.value,
      nature:"note",
      session:this.session,
      semestre:this.semestre,
      groupe:this.classe,
      historiqueElementContitutif:this.historiqueElementContitutif,
      description: this.reclamationForm.get(['description'])!.value,
      etat: "ENCOURS",
      photo: this.reclamationForm.get(['photo'])!.value,
      photoContentType: this.reclamationForm.get(['photoContentType'])!.value,
    }
  }

  reclame(){
    this.reclamation=this.createReclamation();
    this._service.reclamationFromRemote(this.reclamation).subscribe(
      data => {
        alert("votre réclamation est envoyée")
        this._router.navigate(['/cours']);
  
    },
    error => {
      console.log("verifier vos informations");
  },()=>  this._router.navigate(['/cours']))  
    
  }
  byteSize(base64String: string): string {
    return this.dataUtils.byteSize(base64String);
  }
  
  openFile(contentType: string, base64String: string): void {
    this.dataUtils.openFile(contentType, base64String);
  }
  
  setFileData(event: Event, field: string, isImage: boolean): void {
    this.dataUtils.loadFileToForm(event, this.reclamationForm, field, isImage).subscribe(null, (err: JhiFileLoadError) => {
      this.eventManager.broadcast(
        new JhiEventWithContent<any>('ebouclientApp.error', { ...err })
      );
    });
  }

  closes(): void{

    this.dialogRe.closeAll();
  
  }

}