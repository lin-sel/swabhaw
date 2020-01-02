import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ProductListComponent } from './product-list/product-list.component';
import { StarComponent } from './star/star.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ListFilter } from './pipe/Filter.pipe';
import { FormsModule } from '@angular/forms';
import { LoaderComponent } from './loader/loader.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductDetailComponent,
    WelcomeComponent,
    ProductListComponent,
    StarComponent,
    PageNotFoundComponent,
    NavbarComponent,
    ListFilter,
    LoaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
