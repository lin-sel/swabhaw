import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', loadChildren: () => import('./component/home/home.module').then(m => m.HomePageModule) },
  {
    path: 'edit/:id',
    loadChildren: () => import('./component/edit/edit.module').then(m => m.EditPageModule)
  },
  {
    path: 'view/:id',
    loadChildren: () => import('./component/view/view.module').then(m => m.ViewPageModule)
  },
  {
    path: 'add',
    loadChildren: () => import('./component/add/add.module').then(m => m.AddPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
