import { Component, OnInit, Input } from '@angular/core';
import { IStudent } from '../interface/Istudent';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  @Input() student: IStudent;
  constructor() {

  }

  ngOnInit() {
  }

}
