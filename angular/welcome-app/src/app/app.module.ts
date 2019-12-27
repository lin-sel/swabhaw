import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Snake } from './pipes/snake.pipe';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { StudentComponent } from './student/student.component';
import { BlueballComponent } from './blueball/blueball.component';
import { TwoWayComponent } from './two-way/two-way.component';

import { HttpClientModule } from '@angular/common/http';
import { ServiceExampleComponent } from './service-example/service-example.component';
import { NumberComponent } from './number/number.component';
import { OddFact } from './pipes/oddNumberFact.pipe';
import { ParentChildComponent } from './parent-child/parent-child.component';
import { ChildComponent } from './parent-child/child.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    StudentComponent,
    BlueballComponent,
    TwoWayComponent,
    Snake,
    ServiceExampleComponent,
    NumberComponent,
    OddFact,
    ParentChildComponent,
    ChildComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [ParentChildComponent]
})
export class AppModule { }
