import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Injectable } from '@angular/core';
import { MethodCall } from './method-call';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

  createDb() {
      const methodCalls = [
          { name: 'add()', milliseconds: 1 },
          { name: 'subtract()', milliseconds: 24 },
          { name: 'add()', milliseconds: 300 },
          { name: 'add()', milliseconds: 691 },
          { name: 'multiply()', milliseconds: 1041 },
          { name: 'multiply()', milliseconds: 2071 },
          { name: 'add()', milliseconds: 6041 },
          { name: 'subtract()', milliseconds: 10042 },
          { name: 'subtract()', milliseconds: 11342 },
          { name: 'add()', milliseconds: 11421 },
          { name: 'add()', milliseconds: 12449 },
          { name: 'add()', milliseconds: 13981 },
          { name: 'multiply()', milliseconds: 15110 }
      ];
      return {methodCalls};
  }

}
