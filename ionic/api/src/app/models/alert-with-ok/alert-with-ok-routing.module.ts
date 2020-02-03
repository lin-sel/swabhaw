import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AlertWithOkPage } from './alert-with-ok.page';

const routes: Routes = [
  {
    path: '',
    component: AlertWithOkPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AlertWithOkPageRoutingModule {}
