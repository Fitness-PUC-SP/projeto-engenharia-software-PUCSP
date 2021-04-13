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
  nicknameControl = new FormControl('', [Validators.required, Validators.maxLength(30)]);
  fullNameControl = new FormControl('', [Validators.required, Validators.maxLength(255)]);
  emailControl = new FormControl('', [Validators.required, Validators.email, Validators.maxLength(255)]);
  birthdateControl = new FormControl('', [Validators.required]);
  cpfControl = new FormControl('', [Validators.required, Validators.maxLength(11)]);
  cellphoneControl = new FormControl('', [Validators.required, Validators.maxLength(11)]);
  zoomAccountControl = new FormControl('', [Validators.email, Validators.maxLength(255)]);

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

  getEmailErrorMessages() {
    return `
      ${this.getRequiredErrorMessage(this.emailControl, 'e-mail')} / 
      ${this.getEmailValidatorMessage(this.emailControl, 'e-mail')}
    `;
  }

  getNicknameErrorMessages() {
    return `
      ${this.getRequiredErrorMessage(this.nicknameControl, 'apelido')}
    `;
  }

  getFullNameErrorMessages() {
    return `
      ${this.getRequiredErrorMessage(this.fullNameControl, 'nome completo')}
    `;
  }

  getBirthdateErrorMessages() {
    return `
      ${this.getRequiredErrorMessage(this.birthdateControl, 'data de nascimento')}
    `;
  }

  getCpfErrorMessages() {
    return `
      ${this.getRequiredErrorMessage(this.cpfControl, 'CPF')}
    `;
  }

  getCellphoneErrorMessages() {
    return `
      ${this.getRequiredErrorMessage(this.cellphoneControl, 'celular')}
    `;
  }

  getZoomAccountErrorMessages() {
    return `
      ${this.getEmailValidatorMessage(this.zoomAccountControl, 'conta do Zoom')}
    `;
  }



  
  getRequiredErrorMessage(formControl: FormControl, formControlName: string) {
    return formControl.hasError('required') ? `Por favor insira um(a) ${formControlName} válido(a)'` : '';
  }

  getEmailValidatorMessage(formControl: FormControl, formControlName: string) {
    return formControl.hasError('email') ? `${formControlName} inválido(a)` : '';
  }
}