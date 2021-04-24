import { ActivatedRoute } from '@angular/router';
import { Trainer } from './../../models/trainer/trainer';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { IAlert } from 'src/app/sections/alerts-section/alerts-section.component';
import { TrainerService } from "src/app/services/trainer/trainer.service";
import { environment } from 'src/environments/environment';
@Component({
  selector: 'app-trainers',
  templateUrl: './trainers.component.html',
  styleUrls: ['./trainers.component.scss'],
})
export class TrainersComponent implements OnInit {

  trainers: Trainer[] = [];

  alert: IAlert;
  showAlert;

  model = {
    left: true,
    middle: false,
    right: false
  };

  focus;
  focus1;

  constructor(private trainerService : TrainerService) { }
  
  ngOnInit(): void { 
    this.getAllTrainers();
  }
  
  getAllTrainers(): void {
    this.trainerService
      .getAllTrainers()
      .subscribe(result => {
        this.trainers = result.trainers;
      });
  }
   
  showSucessAlert() {
    const successAlert: IAlert = {
      id: 1,
      type: 'success',
      strong: 'Sucesso!',
      message: `Profissionais carregados com sucesso!`,
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