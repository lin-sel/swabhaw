import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'percentage-of', pathMatch: 'full' },
  {
    path: 'percentage-calculate',
    loadChildren: () => import('./componemt/percentage-calculate/percentage-calculate.module').then(m => m.PercentageCalculatePageModule)
  },
  {
    path: 'percentage-difference',
    loadChildren: () => import('./componemt/percentage-difference/percentage-difference.module').then(m => m.PercentageDifferencePageModule)
  },
  {
    path: 'percentage-of',
    loadChildren: () => import('./componemt/percentage-of/percentage-of.module').then(m => m.PercentageOfPageModule)
  },
  {
    path: 'test',
    loadChildren: () => import('./test/test.module').then( m => m.TestPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
