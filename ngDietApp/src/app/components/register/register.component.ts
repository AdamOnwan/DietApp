import { AuthService } from './../../services/auth.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router, private auth: AuthService) { }

  ngOnInit() {
  }
  register(registerForm: NgForm) {
    const user = {
      firstName: registerForm.value.firstName,
      lastName: registerForm.value.lastName,
      email: registerForm.value.email,
      password: registerForm.value.password,
      height: registerForm.value.height,
      weight: registerForm.value.weight,
      imageURL: registerForm.value.imageURL,
      description: registerForm.value.description
    };
    this.auth.register(user).subscribe(
      data => {
        this.auth.login(user.email, user.password).subscribe(
          next => {
            this.router.navigateByUrl('/users');
          });
      });
  }
}
