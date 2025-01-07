import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListProjectComponent } from './views/projects/list-project/list-project.component';
import { CreateProjectComponent } from './views/projects/create-project/create-project.component';
import { EditProjectComponent } from './views/projects/edit-project/edit-project.component';
import { LoginComponent } from './views/auth/login/login.component';
import { SignInComponent } from './views/auth/sign-in/sign-in.component';


@NgModule({
  declarations: [
    AppComponent,
    CreateProjectComponent,
    ListProjectComponent,
    EditProjectComponent,
    LoginComponent,
    SignInComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
