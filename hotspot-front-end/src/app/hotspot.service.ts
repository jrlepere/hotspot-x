import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { MethodCallTimes } from './method-call-times';
import { MethodCall } from './method-call';
import { ObserveOnSubscriber } from 'rxjs/internal/operators/observeOn';

@Injectable({
  providedIn: 'root'
})
export class HotspotService {

  private methodsUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getMethodCallsAll(): Observable<MethodCallTimes> {
      let rootId = 1;
      console.log(this.getRootComponentId());
      this.getRootComponentId().subscribe((id: number) => rootId = id);
      // WAIT??
      console.log(rootId);
      return this.getMethodCalls(rootId);
  }

  getRootComponentId(): Observable<number> {
      const url = `${this.methodsUrl}/rootComponentId`;
      return this.http.get<number>(url)
        .pipe(
            tap(_ => this.log(`fetched root id`)),
            catchError(this.handleError<number>('getRootComponentId()'))
        );
  }

  getMethodCalls(id: number): Observable<MethodCallTimes> {
      const url = `${this.methodsUrl}/methodCallTimes?id=${id}`;
      return this.http.get<MethodCallTimes>(url)
        .pipe(
            tap(_ => this.log(`fetched method calls w/ id=${id}`)),
            catchError(this.handleError<MethodCallTimes>('getMethodCalls(id)'))
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
