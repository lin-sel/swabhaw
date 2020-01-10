import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { PercentageCalculatePageRoutingModule } from './percentage-calculate-routing.module';

import { PercentageCalculatePage } from './percentage-calculate.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    PercentageCalculatePageRoutingModule
  ],
  declarations: [PercentageCalculatePage]
})
export class PercentageCalculatePageModule {}
