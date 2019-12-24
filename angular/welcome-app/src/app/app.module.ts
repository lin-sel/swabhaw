import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { StudentComponent } from './student/student.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    StudentComponent,
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [StudentComponent]
})
export class AppModule { }
