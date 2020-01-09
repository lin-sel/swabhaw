import { Component } from '@angular/core';
// import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { HTTP } from '@ionic-native/http/ngx';
import { Iresponse } from '../interface/response';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  private url: string = 'http://gsmktg.azurewebsites.net:80/api/v1/techlabs/test/students';
  private res: Iresponse;
  // private apikey: string = '2be398c0';
  constructor(private _http: HTTP) {
    this.res = {
      text: null,
      num: 0,
      found: false,
      type: null
    }
  }

  getData() {
    this._http.get(this.url, {}, {}).then(resp => {
      // this.res = JSON.parse(resp.data);
      alert(JSON.stringify(resp));
    }).catch(err => {
      alert(JSON.stringify(err));
    });
  }

  buttonClick() {
    this.getData();
  }



}
