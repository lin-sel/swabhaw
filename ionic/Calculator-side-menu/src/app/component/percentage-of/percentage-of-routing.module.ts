import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PercentageOfPage } from './percentage-of.page';

const routes: Routes = [
  {
    path: '',
    component: PercentageOfPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PercentageOfPageRoutingModule {}
