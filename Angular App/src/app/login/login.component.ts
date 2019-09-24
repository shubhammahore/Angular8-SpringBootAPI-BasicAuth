import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AuthenticationService} from '../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username:string='';
  password:string='';
  invalidLogin = false;
  constructor(private router: Router,
  private loginservice: AuthenticationService) { }
  

  ngOnInit() {
  }
  OnLogin(postForm:{username:string,password:string}){
    console.log(postForm.username);
    console.log(postForm.password);
    this.username=postForm.username;
    this.password=postForm.password;
    (this.loginservice.authenticate(this.username, this.password).subscribe(
      data => {
        this.router.navigate(['/home'])
        this.invalidLogin = false
      },
      error => {
        this.invalidLogin = true

      }
    )
    );

  }

}
