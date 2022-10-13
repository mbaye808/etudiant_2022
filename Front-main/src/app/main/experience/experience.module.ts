
import { ExperienceComponent } from "./experience.component";

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Jtest5SharedModule } from "app/shared/shared.module";
const routes = [
    {
        path     : 'acces',
        component: ExperienceComponent
    }
];

@NgModule({
    declarations: [
        ExperienceComponent,
    ],
    imports: [
        Jtest5SharedModule,
        RouterModule.forChild(routes),
    ],
    exports     : [
        ExperienceComponent
    ]
})

export class ExperienceModule
{
} 