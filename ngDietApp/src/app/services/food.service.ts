import { catchError } from 'rxjs/operators';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Food } from './../models/food';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodService {
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + 'api/foods';
  selected: Food;

  constructor(private http: HttpClient, private router: Router, private authService: AuthService) { }


  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Basic ` + this.authService.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Food[]>(this.url, httpOptions)
    .pipe(
      catchError((err: any) => {
      console.log(err);
      return throwError('FoodService.index() Error');
    })
    );
  }
  getFoodByUserEmail(email: any) {
    if (localStorage.length === 0) {
      this.router.navigateByUrl('/login');
    }
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Basic ` + this.authService.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Food[]>(this.url + '/users' + email, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Error food service - getFoodByUser');
      })
    );
  }
  // create(newFood: Food) {
  //   const httpOptions = {
  //     headers: new
  //   }
  // }
}
