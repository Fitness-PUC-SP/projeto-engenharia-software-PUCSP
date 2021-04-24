import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';

import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LandingComponent } from './landing/landing.component';
import { ProfileComponent } from './profile/profile.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { FooterComponent } from './shared/footer/footer.component';

import { HomeModule } from './home/home.module';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { StudentComponent } from './components/student/student.component';
import { TrainerComponent } from './components/trainer/trainer.component';
import { TrainersComponent } from './components/trainers/trainers.component';
import { StudentService } from './services/student/student.service';
import { TrainerService } from './services/trainer/trainer.service';
import { StudentSearchComponent } from './components/student-search/student-search.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LandingComponent,
    ProfileComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    StudentComponent,
    TrainerComponent,
    TrainersComponent,
    StudentSearchComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    AppRoutingModule,
    HomeModule,
    HttpClientModule,
  ],
  providers: [
    StudentService,
    TrainerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
