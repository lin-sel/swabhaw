import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs/tabs.page';

const routes: Routes = [
      {
            path: 'tabs',
            component: TabsPage,
            children: [
                  {
                        path: 'tab1',
                        children: [
                              {
                                    path: '',
                                    loadChildren: () =>
                                          import('./tab1/tab1.module').then(m => m.Tab1PageModule)
                              }
                        ]
                  },
                  {
                        path: 'tab2',
                        children: [
                              {
                                    path: '',
                                    loadChildren: () =>
                                          import('./tab2/tab2.module').then(m => m.Tab2PageModule)
                              }
                        ]
                  },
                  {
                        path: 'tab3',
                        children: [
                              {
                                    path: '',
                                    loadChildren: () =>
                                          import('./tab3/tab3.module').then(m => m.Tab3PageModule)
                              }
                        ]
                  },
                  {
                        path: '',
                        redirectTo: '/tabs/tab1',
                        pathMatch: 'full'
                  }
            ]
            // loadChildren: () => import('./tabs/tabs.module').then(m => m.TabsPageModule)
      },
      {
            path: 'test',
            loadChildren: () => import('./test/test.module').then(m => m.TestPageModule)
      },
      {
            path: '',
            redirectTo: 'test',
            pathMatch: 'full'
      }
];
@NgModule({
      imports: [
            RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
      ],
      exports: [RouterModule]
})
export class AppRoutingModule { }
