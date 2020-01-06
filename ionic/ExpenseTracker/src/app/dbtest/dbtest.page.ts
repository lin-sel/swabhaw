import { Component, OnInit } from '@angular/core';
import { DatabaseService } from '../service/database.service';

@Component({
  selector: 'app-dbtest',
  templateUrl: './dbtest.page.html',
  styleUrls: ['./dbtest.page.scss'],
})
export class DbtestPage implements OnInit {

  constructor(private _sq: DatabaseService) {
  }

  ngOnInit() {
  }

}
