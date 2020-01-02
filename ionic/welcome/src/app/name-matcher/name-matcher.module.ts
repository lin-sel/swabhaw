import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NameMatcherPageRoutingModule } from './name-matcher-routing.module';

import { NameMatcherPage } from './name-matcher.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NameMatcherPageRoutingModule
  ],
  declarations: [NameMatcherPage]
})
export class NameMatcherPageModule {}
