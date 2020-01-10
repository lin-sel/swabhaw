import { Injectable } from '@angular/core';
import { LoadingController } from '@ionic/angular';

@Injectable({
  providedIn: 'root'
})
export class LoadingService {

  private loading: any;
  constructor(private _loader: LoadingController) { }

  async presentLoadingWithOptions() {
    await this._loader.create({
      spinner: 'circles',
      message: 'Please wait...',
      translucent: true,
      mode: 'ios',
      cssClass: 'custom-class custom-loading'
    }).then((resp) => {
      this.loading = resp;
      console.log("befre start");
      this.loading.present();
    });
  }

  hideLoading(duration: number) {
    setTimeout(() => {
      this.loading.dismiss();
      console.log("dismiss");
    }, duration);
  }
}
