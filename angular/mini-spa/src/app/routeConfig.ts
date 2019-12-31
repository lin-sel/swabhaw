import { Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { CareerComponent } from './career/career.component';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DepartmentComponent } from './department/department.component';

export const routeConfig: Routes = [{
    path: 'about', component: AboutComponent
},
{
    path: 'career', component: CareerComponent
},
{
    path: 'home', component: HomeComponent
},
{
    path: 'depart/:id', component: DepartmentComponent
},
{
    path: '', redirectTo: '/home', pathMatch: 'full'
},
{
    path: '**', component: PageNotFoundComponent
}
];