

import { AccessUpdateComponent } from "./access-update.component";

import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Jtest5SharedModule } from "app/shared/shared.module";
const routes = [
    {
        path     : 'acces',
        component: AccessUpdateComponent
    }
];

@NgModule({
    declarations: [
        AccessUpdateComponent,
    ],
    imports: [
        Jtest5SharedModule,
        RouterModule.forChild(routes),
    ],
    exports     : [
        AccessUpdateComponent
    ],
    schemas: [ CUSTOM_ELEMENTS_SCHEMA]
})

export class AccessUpdateModule
{
} 