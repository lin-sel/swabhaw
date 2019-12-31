import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private showDiv: string;
  // private loader: string;
  constructor() {
    // this.showDiv = 'hide';
    // this.loader = 'main-loader';
  }

  OnInit() {
    this.showDiv = 'show';
    // this.loader = 'hide';
  }
}
