import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AlertWithOkPageRoutingModule } from './alert-with-ok-routing.module';

import { AlertWithOkPage } from './alert-with-ok.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AlertWithOkPageRoutingModule
  ],
  declarations: [AlertWithOkPage]
})
export class AlertWithOkPageModule {}
