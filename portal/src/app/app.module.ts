import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';
import { TrainerComponent } from './components/trainer/trainer.component';
import { TrainerService } from './services/trainer/trainer.service';
import { StudentComponent } from './components/student/student.component';
import { StudentService } from './services/student/student.service';
import { HttpClientModule } from '@angular/common/http';
import { DemoMaterialModule } from './material-module';
import { MatNativeDateModule } from '@angular/material/core';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    TrainerComponent
  ],
  exports: [
    AppComponent,
    StudentComponent,
    TrainerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    DemoMaterialModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })
  ],
  providers: [
    StudentService,
    TrainerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
