import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin!: FormGroup;

  constructor(
    private authService: AuthService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.formLogin = this.formBuilder.group({
          email: ['', Validators.compose([
            Validators.required,
            Validators.email
          ])],
          password: ['',
            Validators.compose([
              Validators.required,
              Validators.minLength(6)
            ])
          ]
        });
  }

  login() {
    this.authService.login(this.formLogin.value).subscribe((res) => {
      this.authService.setAuthToken(res.token);
      this.router.navigate(['/projetos']);
    });
  }

}
