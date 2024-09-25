import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrl = 'http://localhost:8080/customer/find';

  constructor(private http: HttpClient) { }

  requestById(id: any): Observable<any> {
    return this.http.get(this.apiUrl + '/id/' + id);
  }

  requestByDocument(document: any):  Observable<any> {
    return this.http.get(this.apiUrl + '/document/' + document);
  }
}