import { Food } from './../models/food';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  constructor(private http: HttpClient, private router: Router) { }
  private url = 'api/recipes';

  index() {
    return this.http.get<Food[]>(this.url);
  }
  // show(id: number): Observable<any> {
  //   return this.http.get<any>(this.url + '/' + id);
  // }
}
