
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AlumniRoutingModule } from './alumni-routing.module';
import { AlumniComponent } from './alumni.component';
import { MatCardModule } from '@angular/material/card';
import { FuseSharedModule } from '@fuse/shared.module';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
@NgModule({
  declarations: [AlumniComponent],
  imports: [
    CommonModule,
    AlumniRoutingModule,
    FuseSharedModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule
    // Jtest5SemestreModule
  ]
})
export class AlumniModule { }