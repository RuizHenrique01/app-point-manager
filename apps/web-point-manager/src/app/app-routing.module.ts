import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjectsComponent } from './pages/projects/projects.component';
import { CreateProjectComponent } from './pages/projects/components/create-project/create-project.component';

const routes: Routes = [
  {
    path: "",
    redirectTo: 'projetos',
    pathMatch: 'full'
  },
  {
    path: 'projetos',
    component: ProjectsComponent
  },
  {
    path: 'projetos/novo',
    component: CreateProjectComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
