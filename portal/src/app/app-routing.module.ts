import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './components/student/student.component';
import { TrainerComponent } from './components/trainer/trainer.component';

const routes: Routes = [
  { path: '', redirectTo: '.', pathMatch: 'full' },
  { path: 'students', component: StudentComponent },
  { path: 'trainers', component: TrainerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
