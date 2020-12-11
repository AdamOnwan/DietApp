import { catchError } from 'rxjs/operators';
import { User } from 'src/app/models/user';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url = environment.baseUrl + 'api/users';


  constructor(private http: HttpClient, private router: Router, private authService: AuthService) { }

  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Basic ` + this.authService.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<User[]>(this.url, httpOptions)
    .pipe(
      catchError((err: any) => {
      console.log(err);
      return throwError('UserService.index() Error');
    })
    );
  }
}
