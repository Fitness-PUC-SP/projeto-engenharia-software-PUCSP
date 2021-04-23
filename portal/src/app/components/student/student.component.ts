import { Component, OnInit, Input } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Student } from 'src/app/models/student/student';
import { IAlert } from 'src/app/sections/alerts-section/alerts-section.component';
import { StudentService } from 'src/app/services/student/student.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {
  student = {} as Student;

  nicknameControl = new FormControl(this.student.nickname, [Validators.required, Validators.maxLength(30)]);
  fullNameControl = new FormControl(this.student.fullName, [Validators.required, Validators.maxLength(255)]);
  emailControl = new FormControl(this.student.email, [Validators.required, Validators.email, Validators.maxLength(255)]);
  birthdateControl = new FormControl(this.student.birthdate, [Validators.required]);
  cpfControl = new FormControl(this.student.cpf, [Validators.required, Validators.maxLength(11)]);
  cellphoneControl = new FormControl(this.student.cellphone, [Validators.required, Validators.maxLength(11)]);
  zoomAccountControl = new FormControl(this.student.zoomAccount, [Validators.email, Validators.maxLength(255)]);

  alert: IAlert;
  showAlert: boolean;

  model = {
    left: true,
    middle: false,
    right: false
  };

  focus: any;
  focus1: any;

  cpfEnabled: boolean;

  constructor(
    private route: ActivatedRoute,
    private studentService : StudentService) { 
      
    const id = +this.route.snapshot.paramMap.get('id'); // "+": convert string to number in Javascript

    if (id) {
      this.getStudentById(id);
    }
  }

  ngOnInit(): void { }

  getStudentById(id: number): void {
    this.studentService
      .getStudentById(id)
      .subscribe(
        (result:any) => {  // "(result:any)": trecho de código para prevenção do erro de compilação "Property 'student' does not exist on type 'Student'.ts(2339)"
          if (!environment.production) {
            console.log(result);
          }
          
          this.student = result.student;
          
          const {student} = result;   // obtém o objeto "student" do resultado vindo da API

          // TODO: backend retornar campo active ou filtrar por alunos ativos
          // if (student.active == undefined || !student.active) {
          //   this.showErrorAlert(`Aluno ${this.student.id} não encontrado ou desativado`);
          //   return;
          // }

          this.nicknameControl.setValue(student.nickname);
          this.fullNameControl.setValue(student.fullName);

          const studentBirthdate = new Date(Date.parse(student.birthdate));
          const ano = studentBirthdate.getFullYear();
          const mes = studentBirthdate.getMonth() > 10 ? studentBirthdate.getMonth() : `0${studentBirthdate.getMonth()}`;
          const dia = studentBirthdate.getDay() > 10 ? studentBirthdate.getDay() : `0${studentBirthdate.getDay()}`;
          const studentBirthdateToString = `${ano}-${mes}-${dia}`;
          this.birthdateControl.setValue(studentBirthdateToString);
          
          this.cpfControl.setValue(student.cpf);
          this.emailControl.setValue(student.email);
          this.cellphoneControl.setValue(student.cellphone);
          this.zoomAccountControl.setValue(student.zoomAccount);
          
          // TODO: trabalhar na desabilitação dos campos não editáveis
          this.cpfEnabled = false;
        },
        (error) => {
          this.showErrorAlert(`Não foi possível obter o aluno ${this.student.fullName}: ${error}`);
        });
  }

  save() {
    this.student.nickname = this.nicknameControl.value;
    this.student.fullName = this.fullNameControl.value;
    this.student.birthdate = this.birthdateControl.value;
    this.student.cpf = this.cpfControl.value;
    this.student.email = this.emailControl.value;
    this.student.cellphone = this.cellphoneControl.value;
    this.student.zoomAccount = this.zoomAccountControl.value;

    if (this.isTransient()) {
      this.studentService
        .saveStudent(this.student)
        .toPromise()
        .then(() => {
          this.showSucessAlert();
        })
        .catch(error => {
          this.showErrorAlert(`Não foi possível salvar o aluno ${this.student.fullName}: ${error}`);
        });

      return;
    }

    this.studentService
      .updateStudent(this.student)
      .toPromise()
      .then(() => {
        this.showSucessAlert();
      })
      .catch(error => {
        this.showErrorAlert(`Não foi possível atualizar o aluno ${this.student.fullName}: ${error}`);
      });
  }

  isTransient(): boolean {
    if (!this.student.id) {
      return true;
    }

    return this.student.id === 0;
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
  
  showErrorAlert(errorMessage: string) {
    const errorAlert: IAlert = {
      id: 2,
      type: 'danger',
      strong: 'Falha!',
      message: `${errorMessage}. Tente novamente!`,
      icon: 'ni ni-support-16'
    };
    
    this.alert = errorAlert;
    this.showAlert = true;
  }
  
  closeAlert() {
    this.alert = null;
    this.showAlert = false;
  }

  getRequiredErrorMessage(formControl: FormControl, formControlName: string) {
    return formControl.hasError('required') ? `Por favor insira um(a) ${formControlName} válido(a)'` : '';
  }

  getEmailValidatorMessage(formControl: FormControl, formControlName: string) {
    return formControl.hasError('email') ? `${formControlName} inválido(a)` : '';
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
}