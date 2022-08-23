import { Component, OnInit } from '@angular/core';
import {fuseAnimations} from '../../../@fuse/animations';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  animations : fuseAnimations
})
export class HomeComponent implements OnInit {
    modules?: any[] = [
        {
         'titre' :  'Gestion des alumnis',
         'libelle' : 'Ce module contient tout ce qui est relatif aux anciens étudiants'
        },
        {
            'titre' :  'Gestion des Reclamations',
            'libelle' : 'Ce module contient tout ce qui est relatif aux absences'
        },
        {
            'titre' :  'Gestion des bulletins',
            'libelle' : 'Ce module contient tout ce qui est relatif aux bulletins'
        },
        {
            'titre' :  'Gestion des Emplois du temps',
            'libelle' : 'Ce module contient tout ce qui est relatif aux emplois du temps'
        }
    ];

  constructor() {

  }

  ngOnInit(): void {
  }

}
