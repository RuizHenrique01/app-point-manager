import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  continueProcess: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  hanldeContinueProcess(){
    this.continueProcess = !this.continueProcess;
  }

}
