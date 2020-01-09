import { Injectable } from '@angular/core';
import { HTTP, HTTPResponse } from '@ionic-native/http/ngx';
import { Istudent } from '../interface/Istudent';
import { Observable } from 'rxjs';
import { Iresponse } from '../interface/Iresponse';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private student: Istudent[];
  private url: string;
  constructor(private _http: HTTP) {
    this.student = [];
    this.url = 'http://gsmktg.azurewebsites.net:80/api/v1/techlabs/test/students/';
  }

  get(): Observable<Iresponse> {
    return new Observable((observ) => {
      this._http.get(this.url, {}, {}).then((dresp: HTTPResponse) => {
        this.student = JSON.parse(dresp.data);
        observ.next({ status: true, resp: this.student });
      }).catch((err) => {
        console.log(JSON.stringify(err));
        observ.error({ status: false, resp: err });
      });
    });
  }

  getById(id: string): Observable<Iresponse> {
    return new Observable((observe) => {
      let index = this.findIndex(id);
      if (index == -1) {
        this._http.get(`${this.url}/id`, {}, {}).then((dresp: HTTPResponse) => {
          observe.next({ status: true, resp: dresp.data });
        }).catch(err => {
          observe.error({ status: false, resp: err });
        });
        return;
      }
      observe.next({ status: true, resp: this.student[index] });
    });
  }

  delete(id: string): Observable<Iresponse> {
    return new Observable(observe => {
      let index = this.findIndex(id);
      if (index == -1) {
        observe.error({ status: false, resp: "Cant be Delete" });
        return;
      }
      this.student.splice(this.findIndex(id), 1);
      this._http.delete(`${this.url}/${id}`, {}, {}).then(dresp => {
        observe.next({ status: true, resp: dresp });
      }).catch(err => {
        observe.error({ status: false, resp: err });
      });
    });
  }

  update(stud: Istudent): Observable<Iresponse> {
    return new Observable(observe => {
      this._http.put(`${this.url}/${stud.id}`, stud, {}).then(resp => {
        let index = this.findIndex(stud.id);
        if (index == -1) {
          observe.error({ status: false, resp: "Data Not Found" });
          return;
        }
        this.student[index] = stud;
        observe.next({ status: true, resp: resp.status });
      }).catch(err => {
        observe.error({ status: false, resp: err });
      });
    });
  }

  add(stud: Istudent): Observable<Iresponse> {
    return new Observable(observe => {
      this._http.post(`${this.url}`, stud, {}).then(data => {
        if (this.student == null) {
          this.student = [];
        }

        this.student.push(this.getRawDataWithID(data.data.toString(), stud));
        observe.next({ status: true, resp: data.status });
      }).catch(err => {
        observe.error({ status: false, resp: err });
      });
    });
  }

  private getRawDataWithID(id: string, stud): Istudent {
    return {
      id: id,
      rollNo: stud.rollNo,
      name: stud.name,
      age: stud.age,
      email: stud.email,
      date: stud.date,
      isMale: stud.isMale
    };
  }

  private findIndex(id: string): number {
    for (let index = 0; index < this.student.length; index++) {
      if (id == this.student[index].id) {
        return index;
      }
    }
    return -1;
  }

}
