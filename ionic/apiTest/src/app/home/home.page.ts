import { Component, OnInit } from '@angular/core';
// import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
// import { HTTP } from '@ionic-native/http/ngx';
// import { Iresponse } from '../interface/response';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
  // private url: string = 'http://gsmktg.azurewebsites.net:80/api/v1/techlabs/test/students';
  // private res: Iresponse;
  // private apikey: string = '2be398c0';
  // constructor(private _http: HTTP) {
  //   this.res = {
  //     text: null,
  //     num: 0,
  //     found: false,
  //     type: null
  //   }
  // }

  // getData() {
  //   this._http.get(this.url, {}, {}).then(resp => {
  //     // this.res = JSON.parse(resp.data);
  //     alert(JSON.stringify(resp));
  //   }).catch(err => {
  //     alert(JSON.stringify(err));
  //   });
  // }

  // buttonClick() {
  //   this.getData();
  // }

  private form: FormGroup;
  private submitted: boolean;
  constructor(private formBuilder: FormBuilder, private alertController: AlertController) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      age: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      date: ['', Validators.required]
    });
    this.submitted = false;
  }

  get f() {
    return this.form.controls;
  }

  onSubmit() {
    // this.submitted = true;
    // if (this.form.invalid) {
    //   return;
    // }
    // this.presentAlertConfirm();
    this.presentAlert();
    // this.presentAlertMultipleButtons();
    // this.presentAlertConfirm();
  }

  async presentAlert() {
    const alert = await this.alertController.create({
      header: 'Message',
      message: 'This is an alert message.',
      buttons: ['OK']
    });

    await alert.present();
  }

  // async presentAlertMultipleButtons() {
  //   const alert = await this.alertController.create({
  //     header: 'Alert',
  //     subHeader: 'Subtitle',
  //     message: 'This is an alert message.',
  //     buttons: ['Cancel', 'Open Modal', 'Delete']
  //   });

  //   await alert.present();
  // }

  // async presentAlertConfirm() {
  //   const alert = await this.alertController.create({
  //     header: 'Confirm!',
  //     message: 'Message <strong>text</strong>!!!',
  //     buttons: [
  //       {
  //         text: 'Cancel',
  //         role: 'cancel',
  //         cssClass: 'secondary',
  //         handler: (blah) => {
  //           console.log('Confirm Cancel: blah');
  //         }
  //       }, {
  //         text: 'Okay',
  //         handler: () => {
  //           console.log('Confirm Okay');
  //         }
  //       }
  //     ]
  //   });

  //   await alert.present();
  // }

  // async presentAlertPrompt() {
  //   const alert = await this.alertController.create({
  //     header: 'Prompt!',
  //     inputs: [
  //       {
  //         name: 'name1',
  //         type: 'text',
  //         placeholder: 'Placeholder 1'
  //       },
  //       {
  //         name: 'name2',
  //         type: 'text',
  //         id: 'name2-id',
  //         value: 'hello',
  //         placeholder: 'Placeholder 2'
  //       },
  //       {
  //         name: 'name3',
  //         value: 'http://ionicframework.com',
  //         type: 'url',
  //         placeholder: 'Favorite site ever'
  //       },
  //       // input date with min & max
  //       {
  //         name: 'name4',
  //         type: 'date',
  //         min: '2017-03-01',
  //         max: '2018-01-12'
  //       },
  //       // input date without min nor max
  //       {
  //         name: 'name5',
  //         type: 'date'
  //       },
  //       {
  //         name: 'name6',
  //         type: 'number',
  //         min: -5,
  //         max: 10
  //       },
  //       {
  //         name: 'name7',
  //         type: 'number'
  //       }
  //     ],
  //     buttons: [
  //       {
  //         text: 'Cancel',
  //         role: 'cancel',
  //         cssClass: 'secondary',
  //         handler: () => {
  //           console.log('Confirm Cancel');
  //         }
  //       }, {
  //         text: 'Ok',
  //         handler: () => {
  //           console.log('Confirm Ok');
  //         }
  //       }
  //     ]
  //   });

  //   await alert.present();
  // }

}
