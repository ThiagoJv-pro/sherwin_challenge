import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrl = 'http://localhost:8080/customer/create';

  constructor(private http: HttpClient) { }

  send(data: any): Observable<any> {
    return this.http.post(this.apiUrl, data);
  }
}