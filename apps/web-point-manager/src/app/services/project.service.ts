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

  delete(id: number):Observable<Project>{
    return this.http.delete<Project>(this.API + `/${id}`);
  }

  get(id: number):Observable<Project>{
    return this.http.get<Project>(this.API + `/${id}`);
  }

  edit(id: number, project: Project):Observable<Project>{
    return this.http.put<Project>(this.API + `/${id}`, {
      name: project.name,
      description: project.description
    });
  }
}
