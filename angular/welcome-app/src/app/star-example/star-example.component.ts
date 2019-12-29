import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { StarComponent } from '../star/star.component';

@Component({
  selector: 'app-star-example',
  templateUrl: './star-example.component.html',
  styleUrls: ['./star-example.component.css']
})
export class StarExampleComponent implements OnInit {
  private rating: number;
  constructor() { }

  @ViewChild(StarComponent, { static: false }) star;

  ngOnInit() {
  }

  AfterViewInit() {

  }

  onState(event) {
    this.rating = event;
  }

}
