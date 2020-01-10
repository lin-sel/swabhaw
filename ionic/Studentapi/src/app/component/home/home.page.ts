import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../service/apiservice/api.service';
import { Istudent } from '../../interface/Istudent';
import { Router } from '@angular/router';
import { Platform } from '@ionic/angular';
import { LoadingService } from 'src/app/service/loaderservice/loading.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  private student: Istudent[];
  private subscription: any;
  constructor(private _ser: ApiService, private _router: Router, private _loader: LoadingService, private _plateform: Platform) {
    this.student = [];
  }

  ngOnInit() {
    this.ionViewDidEnter();
    this._loader.presentLoadingWithOptions();
    this.get();
  }

  ionViewDidEnter() {
    this.subscription = this._plateform.backButton.subscribe(() => {
      navigator['app'].exitApp();
      this.ionViewWillLeave();
    });
  }

  ionViewWillLeave() {
    this.subscription.unsubscribe();
  }

  get() {
    this._ser.get().subscribe((data) => {
      if (data.status) {
        this.student = data.resp;
        this._loader.hideLoading(200);
        return;
      }
      alert("Server Connectivity error");
    }, (err) => {
      if (err.resp.error != undefined) {
        alert("Please Check your Internet");
        navigator['app'].exitApp();
        return;
      }
      alert(err.resp);
      this._loader.hideLoading(200);
      navigator['app'].exitApp();
    });
  }



  redirectView(id: string) {
    console.log(id);
    this._router.navigate([`/view/${id}`]);
  }




}
