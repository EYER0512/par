import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialesComponent } from './materiales/materiales.component';
import { ProgramasComponent } from './programas/programas.component';
import { TalleresComponent } from './talleres/talleres.component';
import { ActividadComponent } from './actividad.component';
import { RouterOutlet } from "@angular/router";

import {ProgramaService} from "../../providers/services/programa.service";
import {ActividadRoutingModule} from "./actividad-routing.module";
import { FormModalComponent } from './programas/form-modal/form-modal.component';
import {ReactiveFormsModule} from "@angular/forms";
import {TallerService} from "../../providers/services/taller.service";
import { FormModalTallerComponent } from './talleres/form-modal-taller/form-modal-taller.component';
import { CarrerasComponent } from './carreras/carreras.component';
import { FacultadesComponent } from './facultades/facultades.component';
import { TipoPersonaComponent } from './tipo-persona/tipo-persona.component';
import { TipoPersonaService } from "../../providers/services/tipo-persona.service";
import { FormModalTipoPersonaComponent } from './tipo-persona/form-modal-tipo-persona/form-modal-tipo-persona.component';
import { FormModalMaterialesComponent } from './materiales/form-modal-materiales/form-modal-materiales.component';
import { PersonaComponent } from './persona/persona.component';
import { FormModalPersonaComponent } from './persona/form-modal-persona/form-modal-persona.component';
import { PersonaService } from 'src/app/providers/services/persona.service';
import { CarrerasService } from 'src/app/providers/services/carreras.service';
import { MaterialesService } from 'src/app/providers/services/materiales.service';

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
    FormModalMaterialesComponent,
    PersonaComponent,
    FormModalPersonaComponent
  ],
  imports: [
    CommonModule,
    ActividadRoutingModule,
    ReactiveFormsModule

  ],
  providers: [
    ProgramaService,
    TallerService,
    TipoPersonaService,
    PersonaService,
    CarrerasService,
    MaterialesService
  ]
})
export class actividadmodule {


}
