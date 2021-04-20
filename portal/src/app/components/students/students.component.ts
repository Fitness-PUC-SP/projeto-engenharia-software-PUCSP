import { Component, OnInit } from '@angular/core';
import { IAlert } from 'src/app/sections/alerts-section/alerts-section.component';
import { StudentService } from 'src/app/services/student/student.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.scss']
})
export class StudentsComponent implements OnInit {

  students = [];

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

  ngOnInit(): void { 
    this.getAllStudents();
  }
  
  getAllStudents() {
      this.studentService
        .getAllStudents()
        .subscribe(students => { 
            this.students = students;
            console.log(students);
        });
  }

  // getStudentByName(name: string) {
  //   this.studentService
  //     .getStudentByName(name)
  //     .subscribe(_ => this.student = _);
  // }

  showSucessAlert() {
    const successAlert: IAlert = {
      id: 1,
      type: 'success',
      strong: 'Successo!',
      message: `Alunos carregados com sucesso!`,
      icon: 'ni ni-like-2'
    };
    
    this.alert = successAlert;
    this.showAlert = true;
  }
  
  showErrorAlert() {
    const errorAlert: IAlert = {
      id: 2,
      type: 'danger',
      strong: 'Falha!',
      message: `Não foi possível carregar a lista de profissionais. Tente novamente!`,
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