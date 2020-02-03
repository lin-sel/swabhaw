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
        url: '/tabs/tab3',
        icon: 'flash',
        title: 'Percent Difference'
      },
      {
        url: '/tabs/tab2',
        icon: 'flash',
        title: 'Percent Calculate'
      },
      {
        url: '/tabs/tab1',
        icon: 'flash',
        title: 'X Percent Of Y'
      },
    ]
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleBlackTranslucent();
      this.splashScreen.hide();
    });
  }
}
