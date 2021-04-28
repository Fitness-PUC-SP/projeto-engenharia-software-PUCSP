import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Trainer } from 'src/app/models/trainer/trainer';
import { IAlert } from 'src/app/sections/alerts-section/alerts-section.component';
import { TrainerService } from "src/app/services/trainer/trainer.service";
import { environment } from 'src/environments/environment';
@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.scss'],
})
export class TrainerComponent implements OnInit {
    trainer = {} as Trainer;

  nicknameControl = new FormControl(this.trainer.nickname, [Validators.required, Validators.maxLength(30)]);
  fullNameControl = new FormControl(this.trainer.fullName, [Validators.required, Validators.maxLength(255)]);
  emailControl = new FormControl(this.trainer.email, [Validators.required, Validators.email, Validators.maxLength(255)]);
  birthdateControl = new FormControl(this.trainer.birthdate, [Validators.required]);
  cpfControl = new FormControl(this.trainer.cpf, [Validators.required, Validators.maxLength(11)]);
  cnpjControl = new FormControl(this.trainer.cnpj, [Validators.required, Validators.maxLength(14)]);
  cellphoneControl = new FormControl(this.trainer.cellphone, [Validators.required, Validators.maxLength(11)]);
  zoomAccountControl = new FormControl(this.trainer.zoomAccount, [Validators.email, Validators.maxLength(255)]);

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
    private trainerService : TrainerService) { 
      
    const id = +this.route.snapshot.paramMap.get('id'); // "+": convert string to number in Javascript

    if (id) {
      this.getTrainerById(id);
    }
  }
  
  ngOnInit(): void { }

  getTrainerById(id: number): void {
    this.trainerService
      .getTrainerById(id)
      .subscribe(
        (result:any) => {  // "(result:any)": trecho de código para prevenção do erro de compilação "Property 'trainer' does not exist on type 'Trainer'.ts(2339)"
          if (!environment.production) {
            console.log(result);
          }
          
          this.trainer = result.trainer;
          
          const {trainer} = result;   // obtém o objeto "trainer" do resultado vindo da API

          this.nicknameControl.setValue(trainer.nickname);
          this.fullNameControl.setValue(trainer.fullName);

          const trainerBirthdate = new Date(Date.parse(trainer.birthdate));
          const ano = trainerBirthdate.getFullYear();
          const correctMonth = (trainerBirthdate.getMonth() + 1);
          const mes = correctMonth > 10 ? correctMonth : `0${correctMonth}`;
          const dia = trainerBirthdate.getDate()> 10 ? trainerBirthdate.getDate() : `0${trainerBirthdate.getDate()}`;
          const trainerBirthdateToString = `${ano}-${mes}-${dia}`;
          this.birthdateControl.setValue(trainerBirthdateToString);
        
          this.cpfControl.setValue(trainer.cpf);
          this.cnpjControl.setValue(trainer.cnpj);
          this.emailControl.setValue(trainer.email);
          this.cellphoneControl.setValue(trainer.cellphone);
          this.zoomAccountControl.setValue(trainer.zoomAccount);
          
          // TODO: trabalhar na desabilitação dos campos não editáveis
          this.cpfEnabled = false;
        },
        (error) => {
          this.showErrorAlert(`Não foi possível obter o Treinador ${this.trainer.fullName}: ${error}`);
        });
  }

  save() {
    this.trainer.nickname = this.nicknameControl.value;
    this.trainer.fullName = this.fullNameControl.value;
    this.trainer.birthdate = this.birthdateControl.value;
    this.trainer.cpf = this.cpfControl.value;
    this.trainer.cnpj = this.cnpjControl.value;
    this.trainer.email = this.emailControl.value;
    this.trainer.cellphone = this.cellphoneControl.value;
    this.trainer.zoomAccount = this.zoomAccountControl.value;

    if (this.isTransient()) {
      this.trainerService
        .saveTrainer(this.trainer)
        .toPromise()
        .then(() => {
          this.showSuccessAlert();
        })
        .catch(error => {
          this.showErrorAlert(`Não foi possível salvar o Treinador ${this.trainer.fullName}: ${error}`);
        });

      return;
    }

    this.trainerService
      .updateTrainer(this.trainer)
      .toPromise()
      .then(() => {
        this.showSuccessAlert();
      })
      .catch(error => {
        this.showErrorAlert(`Não foi possível atualizar o Treinador ${this.trainer.fullName}: ${error}`);
      });
  }

  isTransient(): boolean {
    if (!this.trainer.id) {
      return true;
    }

    return this.trainer.id === 0;
  }

  showSuccessAlert() {
    const successAlert: IAlert = {
      id: 1,
      type: 'success',
      strong: 'Successo!',
      message: `O Profissional ${this.trainer.fullName} foi salvo com sucesso!`,
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

  getCnpjErrorMessages() {
    return `
      ${this.getRequiredErrorMessage(this.cnpjControl, 'CNPJ')}
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