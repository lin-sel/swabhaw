import { Component, OnInit, ViewContainerRef } from '@angular/core';

@Component({
  selector: 'app-alert-with-ok',
  templateUrl: './alert-with-ok.page.html',
  styleUrls: ['./alert-with-ok.page.scss'],
})
export class AlertWithOkPage implements OnInit {

  constructor(private view: ViewContr) { }

  ngOnInit() {
    this.view.createComponent
  }

}
