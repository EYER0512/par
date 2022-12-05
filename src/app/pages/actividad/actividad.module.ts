import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialesComponent } from './materiales/materiales.component';
import { ProgramasComponent } from './programas/programas.component';
import { TalleresComponent } from './talleres/talleres.component';
import { ActividadComponent } from './actividad.component';
import {RouterOutlet} from "@angular/router";

import {ProgramaService} from "../../providers/services/programa.service";
import {ActividadRoutingModule} from "./actividad-routing.module";
import { FormModalComponent } from './programas/form-modal/form-modal.component';
import {ReactiveFormsModule} from "@angular/forms";
import {TallerService} from "../../providers/services/taller.service";
import { FormModalTallerComponent } from './talleres/form-modal-taller/form-modal-taller.component';
import { CarrerasComponent } from './carreras/carreras.component';
import { FacultadesComponent } from './facultades/facultades.component';
import { TipoPersonaComponent } from './tipo-persona/tipo-persona.component';
import {TipoPersonaService} from "../../providers/services/tipo-persona.service";
import { FormModalTipoPersonaComponent } from './tipo-persona/form-modal-tipo-persona/form-modal-tipo-persona.component';
import { FormModalMaterialesComponent } from './materiales/form-modal-materiales/form-modal-materiales.component';

export let validateAndFlattenComponentImports = undefined;


@NgModule({
  declarations: [
    MaterialesComponent,
    ProgramasComponent,
    TalleresComponent,
    ActividadComponent,
    FormModalComponent,
    FormModalTallerComponent,
    CarrerasComponent,
    FacultadesComponent,
    TipoPersonaComponent,
    FormModalTipoPersonaComponent,
    FormModalMaterialesComponent
  ],
  imports: [
    CommonModule,
    ActividadRoutingModule,
    ReactiveFormsModule

  ],
  providers: [
    ProgramaService,
    TallerService,
    TipoPersonaService
  ]
})
export class actividadmodule {


}
