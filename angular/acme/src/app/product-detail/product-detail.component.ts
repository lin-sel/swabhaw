import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { ActivatedRoute } from '@angular/router';
import { IProduct } from '../interface/Iproduct';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  private product: IProduct;
  constructor(private _ser: ProductService, private _aroute: ActivatedRoute) {
    this.product = this.setEmpty();
    console.log(this.product);
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
        this.product = data.data;
        console.log(this.product);
      }, (err) => {
        console.log(err);
      });
    }, (err) => {
      alert(`Something wrong`);
    });
  }
}
