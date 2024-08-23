import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../interfaces/project.interface';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private readonly API = `${environment.API}/project`;

  constructor(private http: HttpClient) { }

  list(): Observable<Project[]>{
    return this.http.get<Project[]>(this.API);
  }

  create(project: Project): Observable<Project>{
    return this.http.post<Project>(this.API, {
      name: project.name,
      description: project.description
    });
  }
}
