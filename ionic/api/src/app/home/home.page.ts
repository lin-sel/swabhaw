import { Component } from '@angular/core';
import { HTTP } from '@ionic-native/http/ngx';
import { AlertService } from '../service/alert.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  private rest: any;
  constructor(private _http: HTTP, private alertbox: AlertService) {
    this.apiPost();
  }

  onclick() {

  }

  async apiPost() {
    this.rest = await this._http.post('https://reqbin.com/echo/post/json', { "login": "login", "password": "password" }, {});
    console.log(this.rest, JSON.stringify(this.rest));
  }

  async alert() {
    this.alertbox.alertPop();
  }

}
