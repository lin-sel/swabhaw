import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EditComponent } from './edit/edit.component';
import { AddComponent } from './add/add.component';

export const routeConfig: Routes = [{
    path: 'home', component: HomeComponent
},
{
    path: 'edit/:studentid', component: EditComponent
},
{
    path: 'add', component: AddComponent
}] 