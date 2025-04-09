import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';

@Injectable()
export class AuthTokenInterceptor implements HttpInterceptor {

  private ROUTES_WITHOUT_AUTHORIZATION: string[] = [
    '/user/signin',
    '/user/signup'
  ];

  constructor(
    private authService: AuthService
  ) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    if (this.ROUTES_WITHOUT_AUTHORIZATION.find(r => request.url.includes(r)))
      return next.handle(request);

    // Get the auth token from the service.
    const authToken = this.authService.getAuthToken();
    // Clone the request and replace the original headers with
    // cloned headers, updated with the authorization.
    console.log(authToken)
    const authReq = request.clone({
      headers: request.headers.set('Authorization', `Bearer ${authToken}`)
    });

    // send cloned request with header to the next handler.
    return next.handle(authReq);
  }
}
