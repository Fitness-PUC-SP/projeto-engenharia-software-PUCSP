import { Component, OnInit } from '@angular/core';
import { Trainer } from 'src/app/models/trainer/trainer';
import { IAlert } from 'src/app/sections/alerts-section/alerts-section.component';
import { TrainerService } from "src/app/services/trainer/trainer.service";

@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.scss'],
})
export class TrainerComponent implements OnInit {

  trainer: Trainer = {} as Trainer;
  trainers = [];

  alert: IAlert;
  showAlert;

  model = {
    left: true,
    middle: false,
    right: false
  };

  focus;
  focus1;

  constructor(private trainerService : TrainerService) { 
    this.getAllTrainers();
  }
  
  ngOnInit(): void { }
  
  getAllTrainers() {
    this.trainerService
      .getAllTrainers()
      .subscribe(trainers => { 
        this.trainers = trainers;
        console.log(trainers);
      });
  }
  
  // getTrainerByName(name: string) {
  //   this.trainerService
  //     .getTrainerByName(name)
  //     .subscribe(trainer => this.trainer = trainer);
  // }
  
  save() {
    this.trainerService
      .saveTrainer(this.trainer)
      .toPromise()
      .then(() => {
        this.showSucessAlert();
      })
      .catch(() => {
        this.showErrorAlert();
      });
  }

  showSucessAlert() {
    const successAlert: IAlert = {
      id: 1,
      type: 'success',
      strong: 'Successo!',
      message: `O Profissional \"<br>\"${this.trainer.fullName} foi salvo com sucesso!`,
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
      message: `Não foi possível salvar. Tente novamente!`,
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