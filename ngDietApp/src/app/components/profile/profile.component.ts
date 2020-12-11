import { FoodService } from './../../services/food.service';
import { UserService } from './../../services/user.service';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  LoggedInUser: User = new User();
  users: User[] = [];
  // foods: Food[] = [];

  constructor(private userService: UserService, private router: Router, private authService: AuthService,
              private foodService: FoodService) { }

  ngOnInit() {
    this.loadUser();
    this.loadUsers();
  }

  loadUser() {
    this.authService.getUserByEmail(this.authService.getLoggedInEmail()).subscribe(
      yes => {
        this.LoggedInUser = yes;
      },
      no => {

      });
  }
  loadUsers() {
    this.userService.index().subscribe(
      good => {
        this.users = good;
      }
    );
  }
  // loadFood() {
  //   this.foodService.getFoodByUserEmail(this.authService.getLoggedInEmail()).subscribe(
  //     work => {
  //       this.foods = work;
  //     }
  //   );
  // }
}
