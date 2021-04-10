import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Student } from 'src/app/models/student/student';
import { StudentService } from 'src/app/services/student/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  students = [];
  student: Student = {} as Student;
  emailControl = new FormControl('', [Validators.required, Validators.email]);  

  constructor(private studentService : StudentService) { }

  ngOnInit(): void { }

  getStudentByName(name: string) {
    this.studentService
      .getStudentByName(name)
      .subscribe(_ => this.student = _);
  }

  saveStudent(student: Student) {
    this.studentService
      .saveStudent(student)
      .subscribe(_ => {
        this.student = _;
      })
  }

  save(nickname:string, fullName:string, birthdate: string, email: string, cpf: number, cellphone: number, zoomAccount: string) {
    const student = {} as Student;
    student.nickname = nickname;
    student.fullName = fullName;
    student.birthdate = birthdate;
    student.email = email;
    student.cpf = cpf;
    student.cellphone = cellphone;
    student.zoomAccount = zoomAccount;
    
    this.saveStudent(student);
  }

  getErrorMessage() {
    if (this.emailControl.hasError('required')) {
      return 'Por favor insira um e-mail válido';
    }

    return this.emailControl.hasError('email') ? 'E-mail inválido' : '';
  }
}