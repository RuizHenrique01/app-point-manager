import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProjectComponent } from './views/projects/create-project/create-project.component';
import { ListProjectComponent } from './views/projects/list-project/list-project.component';
import { EditProjectComponent } from './views/projects/edit-project/edit-project.component';
import { LoginComponent } from './views/auth/login/login.component';
import { SignInComponent } from './views/auth/sign-in/sign-in.component';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {
    path: "",
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'projetos',
    component: ListProjectComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'projetos/novo',
    component: CreateProjectComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'projetos/editar/:id',
    component: EditProjectComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: SignInComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
