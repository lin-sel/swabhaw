import { Injectable } from '@angular/core';
import { IExpense } from '../interface/IExpense';
import { IResponse } from '../interface/IResponse';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  private data: IExpense[];
  private url: string = "http://192.168.43.6:8080/api/";
  constructor(private _http: HttpClient) {
    // this.data = [{
    //   id: 1,
    //   date: '12/12/2019',
    //   amount: 1220,
    //   category: "Food",
    //   description: "Description"
    // },
    // {
    //   id: 2,
    //   date: '9/12/2019',
    //   amount: 1000,
    //   category: "Entertainment",
    //   description: "Entertainment"
    // }];
  }

  // addExpense(expense: IExpense) {
  //   this.data.push(expense);
  // }

  addExpense(exepse: IExpense) {
    return this._http.post(this.url + "add", exepse);
  }

  // getAllExpense(): IExpense[] {
  //   return this.data;
  // }

  getAll() {
    return this._http.get<IExpense[]>(this.url);
  }

  getTotalLength(): number {
    return this.data.length;
  }

  // updateExpense(data: IExpense): IResponse {
  //   for (let index = 0; index < this.data.length; index++) {
  //     if (data.id == this.data[index].id) {
  //       this.data[index] = data;
  //       return { status: true, data: 'Updated Successfully' };
  //     }
  //   }
  //   return { status: false, data: 'Not Update' };
  // }

  updateExpense(data: IExpense) {
    return this._http.put(this.url + "update", this.data);
  }

  // getExpenseById(id: number): IResponse {
  //   console.log(this.data, id);
  //   for (let index = 0; index < this.data.length; index++) {
  //     if (this.data[index].id == id) {
  //       return { status: true, data: this.data[index] }
  //     }
  //   }
  //   return { status: false, data: "Data Not Found" }
  // }

  getExpenseById(id: number) {
    return this._http.get(this.url + id);
  }

  deleteExpense(id: number) {
    console.log(this.url + "delete/" + id);
    return this._http.delete(this.url + "delete/" + id);
  }
}
