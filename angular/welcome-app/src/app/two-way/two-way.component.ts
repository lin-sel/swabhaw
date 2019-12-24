import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-two-way',
  templateUrl: './two-way.component.html',
  styleUrls: ['./two-way.component.css']
})
export class TwoWayComponent implements OnInit {

  firstname: string;
  lastname: string;
  constructor() { }

  ngOnInit() {
    this.firstname = "ABC";
    this.lastname = "PQR";
  }

  onChange(event) {
    console.log(event);
    this.firstname = event;
  }

}
