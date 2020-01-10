import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'percentage-of',
    pathMatch: 'full'
  },
  {
    path: 'percentage-difference',
    loadChildren: () => import('./component/percentage-difference/percentage-difference.module').then(m => m.PercentageDifferencePageModule)
  },
  {
    path: 'percentage-calculate',
    loadChildren: () => import('./component/percentage-calculate/percentage-calculate.module').then(m => m.PercentageCalculatePageModule)
  },
  {
    path: 'percentage-of',
    loadChildren: () => import('./component/percentage-of/percentage-of.module').then(m => m.PercentageOfPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
