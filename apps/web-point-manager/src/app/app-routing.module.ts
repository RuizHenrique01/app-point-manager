import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProjectComponent } from './projects/create-project/create-project.component';
import { ListProjectComponent } from './projects/list-project/list-project.component';
import { EditProjectComponent } from './projects/edit-project/edit-project.component';

const routes: Routes = [
  {
    path: "",
    redirectTo: 'projetos',
    pathMatch: 'full'
  },
  {
    path: 'projetos',
    component: ListProjectComponent
  },
  {
    path: 'projetos/novo',
    component: CreateProjectComponent
  },
  {
    path: 'projetos/editar/:id',
    component: EditProjectComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
