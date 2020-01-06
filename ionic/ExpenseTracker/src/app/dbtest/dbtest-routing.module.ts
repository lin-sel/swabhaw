import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DbtestPage } from './dbtest.page';

const routes: Routes = [
  {
    path: '',
    component: DbtestPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DbtestPageRoutingModule {}
