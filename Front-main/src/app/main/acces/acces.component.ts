

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';

import * as moment from 'moment';

@Component({
    selector   : 'acces',
    templateUrl: './acces.component.html',
    styleUrls  : ['./acces.component.scss']
})
export class AccesComponent implements OnInit
{


    constructor(private router: Router){}

ngOnDestroy(): void {
   
    }

ngOnInit(): void {

}
accesLien(){
    this.router.navigate(['/log']);
}

}