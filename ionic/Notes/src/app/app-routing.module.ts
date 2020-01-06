import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', loadChildren: () => import('./home/home.module').then(m => m.HomePageModule) },
  {
    path: 'add-note',
    loadChildren: () => import('./add-note/add-note.module').then(m => m.AddNotePageModule)
  },
  {
    path: 'edit-note/:id',
    loadChildren: () => import('./edit-note/edit-note.module').then(m => m.EditNotePageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
