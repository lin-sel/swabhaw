import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-name-matcher',
  templateUrl: './name-matcher.page.html',
  styleUrls: ['./name-matcher.page.scss'],
})
export class NameMatcherPage implements OnInit {
  private person1: string = "";
  private person2: string = "";
  private cal: number = 0;
  constructor() { }

  ngOnInit() {
  }

  calculateMatch() {
    let p1: number = 0;
    for (let i = 0; i < this.person1.length; i++) {
      p1 += this.person1.charCodeAt(i);
    }
    for (let i = 0; i < this.person2.length; i++) {
      p1 += this.person2.charCodeAt(i);
    }
    this.cal = p1 % 101;
  }
}
