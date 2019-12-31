import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public loader: string;
  private showDiv: string;

  constructor() {
    this.loader = 'loader-div';
    this.showDiv = 'hide';
  }

  OnInit() {
  }

  loaderSetting(event) {
    this.loader = event;
    this.showDiv = 'show';
  }
}
