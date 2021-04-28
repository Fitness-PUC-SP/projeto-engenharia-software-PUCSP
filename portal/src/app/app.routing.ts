import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { SignupComponent } from './signup/signup.component';
import { LandingComponent } from './landing/landing.component';
import { LoginComponent } from './login/login.component';
import { StudentComponent } from './components/student/student.component';
import { TrainerComponent } from './components/trainer/trainer.component';
import { TrainersComponent } from './components/trainers/trainers.component';

const routes: Routes =[
    { path: 'home', component: HomeComponent },

    { path: 'homestudentdeactive/:id', component: HomeComponent },
    { path: 'homestudentreactive/:id', component: HomeComponent },
    
    { path: 'hometrainerdeactive/:id', component: HomeComponent },
    { path: 'hometrainerreactive/:id', component: HomeComponent },

    { path: 'user-profile', component: ProfileComponent },
    { path: 'register', component: SignupComponent },
    { path: 'landing', component: LandingComponent },
    { path: 'login', component: LoginComponent },
    { path: 'student', component: StudentComponent },
    { path: 'student/:id', component: StudentComponent },
    { path: 'trainer', component: TrainerComponent },
    { path: 'trainer/:id', component: TrainerComponent },
    { path: 'trainers', component: TrainersComponent },
    { path: '', redirectTo: 'login', pathMatch: 'full' },

];

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes,{
      useHash: true
    })
  ],
  exports: [
  ],
})
export class AppRoutingModule { }
