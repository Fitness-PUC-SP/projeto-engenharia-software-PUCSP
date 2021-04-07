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

  trainer: Trainer = {} as Trainer;
  emailControl = new FormControl('', [Validators.required, Validators.email]);

  constructor(private trainerService : TrainerService) { }
  
  ngOnInit(): void { }
  
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

  save(name: string, surname: string, email: string, cpf: number, cellphone: number, whatsapp: number, zoomAccount: string) {
    const trainer = {} as Trainer;
    trainer.name = name;
    trainer.surname = surname;
    trainer.email = email;
    trainer.cpf = cpf;
    trainer.cellphone = cellphone;
    trainer.whatsapp = whatsapp;
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