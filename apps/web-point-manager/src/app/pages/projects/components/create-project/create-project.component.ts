import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ProjectService } from 'src/app/services/project.service';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {

  formProject!: FormGroup;
  constructor(
    private projectService: ProjectService,
    private router: Router,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.formProject = this.formBuilder.group({
      name: ['', Validators.compose([
        Validators.required,
      ])],
      description: ['']
    });
  }

  createProject(){
    this.projectService.create(this.formProject.value).subscribe(() => {
      this.router.navigate(['/projetos'])
    });
  }

}
