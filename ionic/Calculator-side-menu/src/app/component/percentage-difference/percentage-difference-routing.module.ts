import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PercentageDifferencePage } from './percentage-difference.page';

const routes: Routes = [
  {
    path: '',
    component: PercentageDifferencePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PercentageDifferencePageRoutingModule {}
