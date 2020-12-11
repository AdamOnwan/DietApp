import { User } from './../../models/user';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  user: User = new User();
  email: string = '';

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
    const cred = this.authService.getCredentials();
    this.email = this.authService.getLoggedInEmail();

  }

  userLogInCheck() {
    return this.authService.getCredentials();
  }

  logout() {
    this.authService.logout();
    this.ngOnInit();
    this.router.navigateByUrl('/login');
  }

}
