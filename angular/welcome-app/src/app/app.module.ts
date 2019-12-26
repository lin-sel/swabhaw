import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Snake } from './pipes/snake.pipe';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { StudentComponent } from './student/student.component';
import { BlueballComponent } from './blueball/blueball.component';
import { TwoWayComponent } from './two-way/two-way.component';

import { MathService } from './service/math.service';
import { ServiceExampleComponent } from './service-example/service-example.component';
import { LogService } from './service/log.service';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    StudentComponent,
    BlueballComponent,
    TwoWayComponent,
    Snake,
    ServiceExampleComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [MathService, LogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
