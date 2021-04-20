import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student/student';
import { IAlert } from 'src/app/sections/alerts-section/alerts-section.component';
import { StudentService } from 'src/app/services/student/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {

  student: Student = {} as Student;
  // students = [];

  alert: IAlert;
  showAlert;

  model = {
    left: true,
    middle: false,
    right: false
  };

  focus;
  focus1;

  constructor(private studentService : StudentService) { }

  ngOnInit(): void { }

  // getStudentByName(name: string) {
  //   this.studentService
  //     .getStudentByName(name)
  //     .subscribe(_ => this.student = _);
  // }

  save() {
    this.studentService
      .saveStudent(this.student)
      .toPromise()
      .then(() => {
        this.showSucessAlert();
      })
      .catch(error => {
        this.showErrorAlert(error);
      });
  }

  showSucessAlert() {
    const successAlert: IAlert = {
      id: 1,
      type: 'success',
      strong: 'Successo!',
      message: `O aluno ${this.student.fullName} foi salvo com sucesso!`,
      icon: 'ni ni-like-2'
    };
    
    this.alert = successAlert;
    this.showAlert = true;
  }
  
  showErrorAlert(error: string) {
    const errorAlert: IAlert = {
      id: 2,
      type: 'danger',
      strong: 'Falha!',
      message: `Não foi possível salvar o aluno ${this.student.fullName}. Tente novamente!`,
      icon: 'ni ni-support-16'
    };
    
    this.alert = errorAlert;
    this.showAlert = true;
  }
  
  closeAlert() {
    this.alert = null;
    this.showAlert = false;
  }
}