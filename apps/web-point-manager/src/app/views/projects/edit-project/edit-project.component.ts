import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from 'src/app/interfaces/project.interface';
import { ProjectService } from 'src/app/services/project.service';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.css']
})
export class EditProjectComponent implements OnInit {
  formProject!: FormGroup;
  constructor(
    private projectService: ProjectService,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.projectService.get(Number(this.route.snapshot.paramMap.get('id'))).subscribe(p => {
      this.formProject = this.formBuilder.group({
        name: [p.name, Validators.compose([
          Validators.required,
        ])],
        description: [p.description]
      });
    });
  }

  editProject(){
    this.projectService.edit(Number(this.route.snapshot.paramMap.get('id')), this.formProject.value).subscribe(() => {
      this.router.navigate(['/projetos'])
    });
  }

}
