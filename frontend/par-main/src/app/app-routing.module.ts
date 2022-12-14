import {RouterModule, Routes} from "@angular/router";
import {MainPageComponent} from "./core/main-page/main-page.component";
import {NgModule} from "@angular/core";
import { DashboardComponent } from "./pages/dashboard/dashboard.component";
import { HomeComponent } from "./core/home/home.component";

const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent, children: [ {
      path: 'login',
    loadChildren: ()=> import('./core/core.module').then(m => m.CoreModule)
  }]
  },
  {
    path:'compo',
    component: MainPageComponent,
    children: [
      {
        path: '',
        component: DashboardComponent,
        pathMatch: "full"
      },
      {
        path: 'actividad',
        loadChildren:()=> import('./pages/actividad/actividad.module')
          .then(m => m.actividadmodule)

      }]

  },
  {
    path: '**',
    redirectTo: '',
    pathMatch: 'full'
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
