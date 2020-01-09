import { Injectable } from '@angular/core';
import { IExpense } from '../interface/IExpense';
import { IResponse } from '../interface/IResponse';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { HTTP } from '@ionic-native/http/ngx';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  private data: IExpense[];
  private url: string = "http://192.168.1.22:8080/api/";
  // constructor(private _http: HttpClient) {
  //   this.data = [];
  // }

  constructor(private _http: HTTP) {
    this.data = [];
  }

  // addExpense(exepse): Observable<IResponse> {
  //   return new Observable((observe) => {
  //     this._http.post(this.url + "add", exepse).subscribe((id: string) => {
  //       if (this.data == null) {
  //         this.data = [];
  //       }
  //       this.data.push(this.getRawDataWithId(id, exepse));
  //       observe.next({ status: true, data: "added Successfully" });
  //     }, (err) => {
  //       observe.error({ status: false, data: "Something wrong" });
  //     });
  //   });
  // }

  getAll(): Observable<IResponse> {
    return new Observable((observe) => {
      this._http.get(this.url, {}, {}).then((data) => {
        console.log(data);
        if (this.data == null) {
          this.data = [];
        }
        this.data = data.data;
        observe.next({ status: true, data: this.data });
      }, (err) => {
        console.log(err);
        observe.error({ status: false, data: err.message });
      }).catch(err => {
        console.log(err);
        observe.error({ status: false, data: err.message });
      });
    });
  }

  // getTotalLength(): number {
  //   return this.data.length;
  // }

  // updateExpense(data: IExpense): Observable<IResponse> {
  //   let httpHeaders = {
  //     headers: new HttpHeaders({
  //       'Content-Type': 'application/json',
  //     })
  //   };
  //   return new Observable((observe) => {
  //     this._http.put(this.url + "update/" + data._id, this.getRawDataWithoutId(data), httpHeaders).subscribe((resp) => {
  //       if (resp == 1) {
  //         let index = this.findIndex(data._id);
  //         if (index == -1) {
  //           observe.error({ status: false, data: "Updatable data not found" });
  //           return;
  //         }
  //         this.data[index] = data;
  //         observe.next({ status: true, data: "Expense Updated" });
  //       }
  //     }, (err) => {
  //       console.log(err);
  //       observe.error({ status: false, data: "Something wrong with server" });
  //     });
  //   });
  // }

  // getExpenseById(id: string) {
  //   return this._http.get(this.url + id);
  // }

  // deleteExpense(id: string) {
  //   console.log(this.url + "delete/" + id);
  //   this.data.splice(this.findIndex(id), 1);
  //   return this._http.delete(this.url + "delete/" + id);
  // }

  private getRawDataWithId(id: string, data) {
    return {
      _id: id,
      date: data.date,
      amount: data.amount,
      category: data.category,
      description: data.description
    };
  }

  private getRawDataWithoutId(data) {
    return {
      date: data.date,
      amount: data.amount,
      category: data.category,
      description: data.description
    };
  }

  private findIndex(id: string): number {
    for (let index = 0; index < this.data.length; index++) {
      if (id == this.data[index]._id) {
        return index;
      }
    }
    return -1
  }

  // addExpense(exepse): Observable<IResponse> {
  //   return new Observable((observe) => {
  //     this._http.post(this.url + "add", exepse).subscribe((id: string) => {
  //       if (this.data == null) {
  //         this.data = [];
  //       }
  //       this.data.push(this.getRawDataWithId(id, exepse));
  //       observe.next({ status: true, data: "added Successfully" });
  //     }, (err) => {
  //       observe.error({ status: false, data: "Something wrong" });
  //     });
  //   });
  // }

  // getAll(): Observable<IResponse> {
  //   return new Observable((observe) => {
  //     this._http.get<IExpense[]>(this.url).than((data) => {
  //       if (this.data == null) {
  //         this.data = [];
  //       }
  //       this.data = data;
  //       observe.next({ status: true, data: this.data });
  //     }, (err) => {
  //       observe.error({ status: false, data: err.message });
  //     });
  //   });
  // }

  // getTotalLength(): number {
  //   return this.data.length;
  // }

  // updateExpense(data: IExpense): Observable<IResponse> {
  //   let httpHeaders = {
  //     headers: new HttpHeaders({
  //       'Content-Type': 'application/json',
  //     })
  //   };
  //   return new Observable((observe) => {
  //     this._http.put(this.url + "update/" + data._id, this.getRawDataWithoutId(data), httpHeaders).subscribe((resp) => {
  //       if (resp == 1) {
  //         let index = this.findIndex(data._id);
  //         if (index == -1) {
  //           observe.error({ status: false, data: "Updatable data not found" });
  //           return;
  //         }
  //         this.data[index] = data;
  //         observe.next({ status: true, data: "Expense Updated" });
  //       }
  //     }, (err) => {
  //       console.log(err);
  //       observe.error({ status: false, data: "Something wrong with server" });
  //     });
  //   });
  // }

  // getExpenseById(id: string) {
  //   return this._http.get(this.url + id);
  // }

  // deleteExpense(id: string) {
  //   console.log(this.url + "delete/" + id);
  //   this.data.splice(this.findIndex(id), 1);
  //   return this._http.delete(this.url + "delete/" + id);
  // }

  // private getRawDataWithId(id: string, data) {
  //   return {
  //     _id: id,
  //     date: data.date,
  //     amount: data.amount,
  //     category: data.category,
  //     description: data.description
  //   };
  // }

  // private getRawDataWithoutId(data) {
  //   return {
  //     date: data.date,
  //     amount: data.amount,
  //     category: data.category,
  //     description: data.description
  //   };
  // }

  // private findIndex(id: string): number {
  //   for (let index = 0; index < this.data.length; index++) {
  //     if (id == this.data[index]._id) {
  //       return index;
  //     }
  //   }
  //   return -1
  // }
}
