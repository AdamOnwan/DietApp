import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { catchError, tap } from 'rxjs/operators';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = environment.baseUrl;

  userLoggedIn = false;

  constructor(private http: HttpClient) { }



  userLogInCheck() {
    if (this.getCredentials) {
      return true;
    } else {
      return false;
    }
  }
  login(email, password) {
    this.userLoggedIn = true;
    const credentials = this.generateBasicAuthCredentials(email, password);
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    return this.http.get(this.baseUrl + 'authenticate', httpOptions).pipe(
      tap(res => {
        localStorage.setItem('credentials', credentials);
        localStorage.setItem('email', email);
        return res;
      }),
      catchError((err: any) => {
        return throwError('AuthService.login(): Error logging in.');
      })
    );
  }
  register(user) {
    return this.http.post(this.baseUrl + 'register', user).pipe(
      catchError((err: any) => {
        return throwError('AuthService.register(): error registering user.');
      })
    );
  }
  logout() {
    this.userLoggedIn = false;
    localStorage.removeItem('credentials');
    localStorage.removeItem('email');
  }

  checkLogin() {
    if (localStorage.getItem('credentials')) {
      return true;
    }
    return false;
  }
  generateBasicAuthCredentials(email, password) {
    return btoa(`${email}:${password}`);
  }
  getCredentials() {
    return localStorage.getItem('credentials');
  }

  getLoggedInEmail() {
    return localStorage.getItem('email');
  }
  getUserByEmail(email: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Headers': 'Content-Type',
        Authorization: `Basic ` + this.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<User>(this.baseUrl + 'api/users/' + email, httpOptions).pipe(catchError((err: any) => {
      return throwError('AuthService.register(): error registering user.');
    })
    );
  }
}
