import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { IProduct } from '../interface/Iproduct';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { IResponse } from '../interface/Iresponse';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  private product: IProduct;
  private loaderblock: string;
  private datablock: string;
  constructor(private _ser: ProductService, private _aroute: ActivatedRoute, private _router: Router) {
    this.product = this.setEmpty();
    this.loaderblock = 'show';
    this.datablock = 'hide';
  }

  ngOnInit() {
    this.getProduct();
  }

  setEmpty() {
    return {
      description: "",
      imageUrl: "",
      price: 0,
      productCode: "",
      productId: 0,
      productName: "",
      releaseDate: "",
      starRating: 0
    }
  }

  getProduct() {
    this._aroute.paramMap.subscribe((data) => {
      console.log(data.get('productid'));
      this._ser.getProductById(parseInt(data.get('productid'))).subscribe((data) => {
        this.chechStatus(data);
        console.log(data);
      }, (err) => {
        console.log(err);
      });
    }, (err) => {
      alert(`Something wrong`);
    });
  }

  chechStatus(data: IResponse) {
    if (data.status) {
      this.product = data.data;
      this.loaderSetting();
      return;
    }
    alert(`${data.data}`);
    this._router.navigate(['/productlist']);
  }

  loaderSetting() {
    if (this.loaderblock == 'show') {
      this.loaderblock = 'hide';
      this.datablock = 'show';
      return;
    }
    this.loaderblock = 'show';
    this.datablock = 'hide';
  }
}
