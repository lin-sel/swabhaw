import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IStudent } from './interface/Istudent';
import { Observable } from 'rxjs';
import { Ireponsetype } from './interface/Iresponsetype';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {
  private url: string;
  private data: IStudent[] = Array();
  constructor(private _http: HttpClient) {
    this.url = 'http://gsmktg.azurewebsites.net:80/api/v1/techlabs/test/students/';
  }

  getStudentList(): Observable<IStudent[]> {
    return this._http.get<IStudent[]>(this.url, { responseType: 'json' });
  }

  getStudent(id): Observable<IStudent> {
    return this._http.get<IStudent>(this.url + id);
  }

  putStudentDetail(data, id): Observable<Object> {
    return this._http.put(this.url + id, data);
  }

  deleteStudent(id): Observable<Object> {
    return this._http.delete(this.url + id);
  }

  addStudent(data: IStudent): Observable<Object> {
    return this._http.post(this.url, data);
  }
}
