
import { AccesComponent } from "./acces.component";

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Jtest5SharedModule } from "app/shared/shared.module";
const routes = [
    {
        path     : 'acces',
        component: AccesComponent
    }
];

@NgModule({
    declarations: [
        AccesComponent,
    ],
    imports: [
        Jtest5SharedModule,
        RouterModule.forChild(routes),
    ],
    exports     : [
        AccesComponent
    ]
})

export class AccesModule
{
}