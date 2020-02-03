import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PercentageDifferencePageRoutingModule } from './percentage-difference-routing.module';

import { PercentageDifferencePage } from './percentage-difference.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PercentageDifferencePageRoutingModule
  ],
  declarations: [PercentageDifferencePage]
})
export class PercentageDifferencePageModule {}
