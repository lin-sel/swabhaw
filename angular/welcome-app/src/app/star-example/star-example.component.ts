import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { StarComponent } from '../star/star.component';

@Component({
  selector: 'app-star-example',
  templateUrl: './star-example.component.html',
  styleUrls: ['./star-example.component.css']
})
export class StarExampleComponent implements OnInit {

  constructor() { }

  @ViewChild(StarComponent, { static: false }) star;

  ngOnInit() {
  }

  AfterViewInit() {

  }

}
