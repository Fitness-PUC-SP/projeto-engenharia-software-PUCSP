import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IAlert } from '../sections/alerts-section/alerts-section.component';
import { StudentService } from '../services/student/student.service';
import { TrainerService } from '../services/trainer/trainer.service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  model = {
      left: true,
      middle: false,
      right: false
  };

  focus;
  focus1;
  alert: IAlert;
  showAlert: boolean;
  id: number;

  constructor(
    private route: ActivatedRoute,
    private studentService: StudentService,
    private trainerService: TrainerService) { 
      
    this.id = +this.route.snapshot.paramMap.get('id'); // "+": convert string to number in Javascript

    const rota = route.pathFromRoot[1].snapshot.url[0].path;

    if (this.id) {
      if (rota.indexOf('student') > 0) {
        this.studentService.deleteStudent(this.id)
          .subscribe(
            (result:any) => {  // "(result:any)": trecho de código para prevenção do erro de compilação "Property 'student' does not exist on type 'Student'.ts(2339)"
                alert("Aluno desativado com sucesso!");
            },
            (error) => {
                alert('Não foi possível desativar o aluno');
          });
      } else if (rota.indexOf('trainer') > 0) {
        this.trainerService.deleteTrainer(this.id)
          .subscribe(
            (result:any) => {  
                alert("Profissional desativado com sucesso!");
            },
            (error) => {
                alert('Não foi possível desativar o Profissional');
            });
      }
    }
  }

  ngOnInit() {}
}
