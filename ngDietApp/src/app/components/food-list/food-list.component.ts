import { User } from '../../models/user';
import { AuthService } from '../../services/auth.service';
import { FoodService } from '../../services/food.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Food } from 'src/app/models/food';

@Component({
  selector: 'app-food-list',
  templateUrl: './food-list.component.html',
  styleUrls: ['./food-list.component.css']
})
export class FoodListComponent implements OnInit {
  foods: Food[] = [];
  selectedFood: Food = null;
  loggedInUser: User = new User();

  constructor(private foodSvc: FoodService, private router: Router, private authService: AuthService) { }

  ngOnInit() {
    this.getAllFoods();
  }

  loadUser() {
    this.authService.getUserByEmail(this.authService.getLoggedInEmail()).subscribe(
      yes => {
        this.loggedInUser = yes;
      },
      no => {
      });
  }
  getAllFoods() {
    this.foodSvc.index().subscribe(
      data => {
        this.foods = data;
      },
      err => {
        console.error(err);
      });
  }

}
