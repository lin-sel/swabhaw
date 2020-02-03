import { Component } from '@angular/core';

import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent {

  private menuList: any[];
  constructor(
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar
  ) {
    this.initializeApp();
    this.menuList = [
      {
        url: '/percentage-difference',
        icon: 'flash',
        title: 'Percent Difference'
      },
      {
        url: '/percentage-calculate',
        icon: 'flash',
        title: 'Percent Calculate'
      },
      {
        url: '/percentage-of',
        icon: 'flash',
        title: 'X Percent Of Y'
      },
    ]
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }
}
