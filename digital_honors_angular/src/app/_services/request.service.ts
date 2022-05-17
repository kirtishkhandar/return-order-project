import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const Request_API = 'http://localhost:8765/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  constructor(private http: HttpClient) { }

  getDetails(name: string, contactNumber: string, componentType:string, componentName:string, quantity:number): Observable<any> {
    return this.http.post(Request_API + 'ProcessDetail', {
      name, contactNumber, componentType, componentName, quantity
    }, httpOptions);
  }

  payment(requestId: string, cardNumber: string, cardLimit:string, processingCharge: string): Observable<any> {
    return this.http.post(Request_API + 'CompleteProcessing', {
      requestId, cardNumber, cardLimit, processingCharge
    }, httpOptions);
  }
}
