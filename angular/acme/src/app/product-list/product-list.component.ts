import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { IProduct } from '../interface/Iproduct';
import { Router } from '@angular/router';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  private products: IProduct[] = Array();
  private image: string;
  public input: string;
  private loaderblock: string = 'show';
  private datablock: string = 'hide';
  constructor(private _ser: ProductService, private _router: Router) {
    this.getAllProduct();
  }

  ngOnInit() {
    this.image = 'show';
  }

  getAllProduct() {
    this._ser.getProduct().subscribe(resp => {
      this.products = resp.data;
      this.loaderSetting();
      console.log(this.products);
    }, (err) => {
      console.log(err);
    })
  }

  onImageClick() {
    if (this.image == 'show') {
      this.image = 'hide';
      return;
    }
    this.image = 'show';
  }

  redirectToDetail(product: IProduct) {
    console.log(product);
    this._router.navigate(['/productdetail/' + product]);
  }

  loaderSetting() {
    console.log(this.datablock, this.loaderblock);
    if (this.loaderblock == 'show') {
      this.loaderblock = 'hide';
      this.datablock = 'show';
      return;
    }
    this.loaderblock = 'show';
    this.datablock = 'hide';
  }
}
