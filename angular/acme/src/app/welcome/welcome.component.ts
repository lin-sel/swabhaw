import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  private loaderblock: string;
  private datablock: string;
  constructor() {
    this.datablock = 'hide';
    this.loaderblock = 'show';
  }

  ngOnInit() {
    this.datablock = 'show';
    this.loaderblock = 'hide';
  }

  AfterViewInit() {

  }

}
