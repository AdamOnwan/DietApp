import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  accessDenied = false;
  constructor(private router: Router, private auth: AuthService) {}

  ngOnInit() {}

  login(loginForm: NgForm) {
    const user: User = new User();
    user.email = loginForm.value.email;
    user.password = loginForm.value.password;

    this.auth.login(user.email, user.password).subscribe(
      (next) => {
        this.router.navigate(['/users']);
      },
      (error) => {
        this.accessDenied = true;
        this.router.navigateByUrl('/login');
      }
    );
  }
}
