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
  emailControl = new FormControl('', [Validators.required, Validators.email]);

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

  getErrorMessage() {
    if (this.emailControl.hasError('required')) {
      return 'Por favor insira um e-mail válido';
    }

    return this.emailControl.hasError('email') ? 'E-mail inválido' : '';
  }
}