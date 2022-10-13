


import { ExperienceUpdateComponent } from "./experience-update.component";

import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Jtest5SharedModule } from "app/shared/shared.module";
const routes = [
    {
        path     : 'exp',
        component: ExperienceUpdateComponent
    }
];

@NgModule({
    declarations: [
        ExperienceUpdateComponent,
    ],
    imports: [
        Jtest5SharedModule,
        RouterModule.forChild(routes),
    ],
    exports     : [
        ExperienceUpdateComponent
    ],
    schemas: [ CUSTOM_ELEMENTS_SCHEMA]
})

export class ExperienceUpdateModule
{
} 