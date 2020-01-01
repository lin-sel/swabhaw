import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IProduct } from '../interface/Iproduct';
import { IResponse } from '../interface/Iresponse';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private url: string;
  private product: IProduct[] = Array();
  constructor(private _http: HttpClient) {
    this.url = 'assets/resource/products.json';
  }

  getProduct(): Observable<IResponse> {
    return new Observable<IResponse>((observer) => {
      if (this.product.length == 0) {
        this._http.get<IProduct[]>(this.url).subscribe((datas: IProduct[]) => {
          console.log('Service Data Fetch');
          this.product = datas;
          observer.next({ status: true, data: datas });
        }, (err) => {
          observer.error({ status: false, data: "Data not Found" });
        });
        return;
      }
      observer.next({ status: true, data: this.product });
    });
  }

  getProductById(id: number): Observable<IResponse> {
    return new Observable<IResponse>((observer) => {
      if (this.product.length == 0) {
        this.getProduct().subscribe((data) => {
          observer.next({ status: true, data: this.findData(id).data });
          console.log(data.data);
          this.product = data.data;
        }, (err) => {
          observer.error({ status: false, data: err });
          return;
        });
        return;
      }
      observer.next({ status: true, data: this.findData(id).data });
    });
  }

  findData(id: number): IResponse {
    console.log(id, this.product);
    for (let index = 0; index < this.product.length; index++) {
      if (this.product[index].productId == id) {
        return { status: true, data: this.product[index] };
      }
    }
    return { status: false, data: "Data Not Found" }
  }
}