import {RouterModule, Routes} from "@angular/router";
import {Component, NgModule} from "@angular/core";

//import { DashboardComponent } from "./pages/dashboard/dashboard.component";
//import * as path from "path";
import {ActividadComponent} from "./actividad.component";
import {MaterialesComponent} from "./materiales/materiales.component";
import {ProgramasComponent} from "./programas/programas.component";
import {TalleresComponent} from "./talleres/talleres.component";
import {TipoPersonaComponent} from "./tipo-persona/tipo-persona.component";
import { CarrerasComponent } from "./carreras/carreras.component";
import { PersonaComponent } from "./persona/persona.component";
import { AsistenciasComponent } from "./asistencias/asistencias.component";
const routes: Routes = [
  {
    path:'',
    component: ActividadComponent,
    children: [
      {
        path: 'materiales',
        component: MaterialesComponent,
      },
      {
        path: 'programas',
        component: ProgramasComponent,
      },
      {
        path: 'talleres',
        component: TalleresComponent,
      },
      {
        path: 'tipopersonas',
        component: TipoPersonaComponent
      },
      {
        path: 'carreras',
        component: CarrerasComponent
      },
      {
        path: 'persona',
        component: PersonaComponent
      },
      {
        path: 'asistencias',
        component: AsistenciasComponent
      }
    ]
  }
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ActividadRoutingModule {
}
