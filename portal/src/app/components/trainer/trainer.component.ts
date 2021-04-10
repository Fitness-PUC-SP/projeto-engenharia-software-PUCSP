import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Trainer } from 'src/app/models/trainer/trainer';
import { TrainerService } from "src/app/services/trainer/trainer.service";

@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {

  trainers = [];
  trainer: Trainer = {} as Trainer;
  nicknameControl = new FormControl('', [Validators.required, Validators.maxLength(30)]);
  fullNameControl = new FormControl('', [Validators.required, Validators.maxLength(60)]);
  emailControl = new FormControl('', [Validators.required, Validators.email, Validators.maxLength(60)]);
  birthdateControl = new FormControl('', [Validators.required]);
  cpfControl = new FormControl('', [Validators.required, Validators.maxLength(11)]);
  cnpjControl = new FormControl('', [Validators.required, Validators.maxLength(12)]);
  cellphoneControl = new FormControl('', [Validators.required, Validators.maxLength(11)]);
  zoomAccountControl = new FormControl('', [Validators.required, Validators.email]);

  constructor(private trainerService : TrainerService) { }
  
  ngOnInit(): void { }
  
  getAllTrainers() {
    this.trainerService
      .getAllTrainers()
      .subscribe(trainers => { 
        this.trainers = trainers;
        console.log(trainers);
      });
  }
  
  getTrainerByName(name: string) {
    this.trainerService
      .getTrainerByName(name)
      .subscribe(trainer => this.trainer = trainer);
  }
  
  saveTrainer(trainer: Trainer) {
    this.trainerService
      .saveTrainer(trainer)
      .subscribe(_ => {
        this.trainer = _;
      });
  }

  save(nickname: string, fullname: string, birthdate: string, email: string, cpf: number, cnpj: number, cellphone: number, zoomAccount: string) {
    const trainer = {} as Trainer;
    trainer.nickname = nickname;
    trainer.fullName = fullname;
    trainer.birthdate = birthdate;
    trainer.email = email;
    trainer.cpf = cpf;
    trainer.cnpj = cnpj;
    trainer.cellphone = cellphone;
    trainer.zoomAccount = zoomAccount;

    this.saveTrainer(trainer);
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
      ${this.getRequiredErrorMessage(this.zoomAccountControl, 'conta do Zoom')} / 
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