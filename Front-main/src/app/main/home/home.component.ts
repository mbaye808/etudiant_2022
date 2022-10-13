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
         'titre' :  'Alumni',
         'libelle' : 'Ce module contient tout ce qui est relatif aux anciens étudiants'
        },
        {
            'titre' :  'Reclamations',
            'libelle' : 'Ce module contient tout ce qui est relatif à la gestion des réclamations de note ou autres type de réclamations'
        },
        {
            'titre' :  'Bulletins et Relevés',
            'libelle' : 'Ce module contient tout ce qui est relatif aux bulletins de notes et relevés'
        },
        {
            'titre' :  'Emplois du temps',
            'libelle' : "Ce module contient tout ce qui est relatif à la gestion de l'horaire de l'étudiant"
        }
    ];

  constructor() {

  }

  ngOnInit(): void {
  }

}
