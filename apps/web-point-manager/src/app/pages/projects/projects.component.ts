import { Component, OnInit } from '@angular/core';
import { Project } from 'src/app/interfaces/project.interface';
import { ProjectService } from 'src/app/services/project.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  listProject: Project[] = [];

  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    this.projectService.list().subscribe(r => this.listProject = r);
  }

}
