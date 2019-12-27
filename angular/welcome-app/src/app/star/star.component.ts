import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-star',
  templateUrl: './star.component.html',
  styleUrls: ['./star.component.css']
})
export class StarComponent implements OnInit {
  private starclass = "starclass";
  private starimg = '/assets/img/favorite.svg';
  @Input() rating: number;
  @Input() private size: number;
  private iterativeArray: number[] = [];

  constructor() {
    this.size = 50;
    this.rating = 3.5;
  }

  ngOnInit() {
    this.getArray();
  }

  private getArray() {
    while (this.rating > 0) {
      if (this.rating > 0 && this.rating < 1) {
        this.iterativeArray.push(Math.round(this.rating * 100));
        this.rating -= 1;
      }
      else {
        this.iterativeArray.push(100);
        this.rating -= 1;
      }
    }
  }

}
