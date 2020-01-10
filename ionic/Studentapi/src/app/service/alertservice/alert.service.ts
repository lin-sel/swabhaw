import { Injectable } from '@angular/core';
import { AlertController, ToastController } from '@ionic/angular';
import { async } from '@angular/core/testing';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  constructor(private alertController: AlertController, private _toastController: ToastController) { }

  async presentAlertConfirm(header, message) {
    const alert = await this.alertController.create({
      header: header,
      message: message,
      buttons: [{
        text: 'Cancel',
        role: 'cancel',
        handler: () => {
          this.toast('Operation Cancelled', 2000);
          return false;
        },
      },
      {
        text: 'Delete',
        role: 'delete',
        handler: () => {
          return true;
        }
      }
      ]
    });
    let resp = await alert.present();
    return resp;
  }

  async toast(message, duration) {
    const toast = await this._toastController.create({
      message: message,
      duration: duration,
      mode: 'ios',
    });
    toast.present();
  }
}
