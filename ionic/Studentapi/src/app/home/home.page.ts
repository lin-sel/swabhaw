import { Component } from '@angular/core';
import { ApiService } from '../service/api.service';
import { Istudent } from '../interface/Istudent';
import { Router } from '@angular/router';
import { Platform } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  private student: Istudent[];
  constructor(private _ser: ApiService, private _router: Router) {
    this.student = [];
    this.get();
  }

  get() {
    this._ser.get().subscribe((data) => {
      if (data.status) {
        this.student = data.resp;
        return;
      }
      alert("Server Connectivity error");
    }, () => {
      alert("Something wrong with Request");
    });
  }



  redirectView(id: string) {
    console.log(id);
    this._router.navigate([`/view/${id}`]);
  }


}
