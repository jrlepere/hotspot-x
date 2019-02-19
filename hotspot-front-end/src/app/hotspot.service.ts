import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';


import { MethodCall } from './method-call';

@Injectable({
  providedIn: 'root'
})
export class HotspotService {

  private methodsUrl = 'api/methodCalls';

  constructor(private http: HttpClient) { }

  getMethodCalls(): Observable<MethodCall[]> {
      return this.http.get<MethodCall[]>(this.methodsUrl)
        .pipe(
            tap(_ => this.log('fetched method calls')),
            catchError(this.handleError('getMethodCalls()', []))
        );
  }

  private log(message: string) {
      console.log(message);
  }

  private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {
          console.error(error);
          this.log(`${operation} failed: ${error.message}`);
          return of(result as T);
      };
  }

}
