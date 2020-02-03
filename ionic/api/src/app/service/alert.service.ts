import { Injectable } from '@angular/core';
import { ModalController, AlertController } from '@ionic/angular';
import { AlertWithOkPage } from '../models/alert-with-ok/alert-with-ok.page';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  constructor(
    private modalCon: ModalController,
    private alert: AlertController
  ) { }

  alertWithOk() {
    this.modalCon.create({
      component: AlertWithOkPage,
      componentProps: {}
      
    });
  }

  async alertPop() {
    let alt = await this.alert.create({
      buttons: ['Ok', 'Cancel', { text: 'Ok', cssClass: 'alert-Button' }, 'Cancel'],
      header: 'Alert',
      message: 'Alert Message ok',
      cssClass: 'alert-css',
      mode: 'ios',
    });
    alt.present();
  }
}
