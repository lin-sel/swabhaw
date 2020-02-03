import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PercentageCalculatePage } from './percentage-calculate.page';

const routes: Routes = [
  {
    path: '',
    component: PercentageCalculatePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PercentageCalculatePageRoutingModule {}
