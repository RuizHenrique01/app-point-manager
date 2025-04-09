import { HttpClient } from '@angular/common/http';
import { Injectable, enableProdMode } from '@angular/core';
import { environment } from 'src/environments/environment';
import { IAuth } from '../interfaces/auth.interface';
import { Observable } from 'rxjs';
import * as storage from 'src/app/utils/storage.util';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly API = `${environment.API}/user`;

  constructor(private http: HttpClient) { }

  login(data: IAuth): Observable<any> {
    return this.http.post<IAuth>(this.API + "/signin", {
      email: data.email,
      password: data.password
    });
  }

  setAuthToken(token: string) {
    storage.setLocalStorageItem('token', token);
  }

  getAuthToken(): string | null {
    return storage.getLocalStorageItem('token');
  }

}
