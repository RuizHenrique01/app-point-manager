import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/interfaces/project.interface';
import { ProjectService } from 'src/app/services/project.service';

@Component({
  selector: 'app-list-project',
  templateUrl: './list-project.component.html',
  styleUrls: ['./list-project.component.css']
})
export class ListProjectComponent implements OnInit {

  listProject: Project[] = [];
  projectSelected?: Project;

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    this.listProjects();
  }

  listProjects() {
    this.projectService.list().subscribe(r => this.listProject = r);
  }

  selectProject(project: Project){
    this.projectSelected = project;
  }

  deleteProject(){
    this.projectService.delete(this.projectSelected!.id).subscribe(() => this.listProjects());
  }
}
