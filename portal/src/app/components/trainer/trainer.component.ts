import { Component, OnInit } from '@angular/core';
import { Trainer } from 'src/app/models/trainer/trainer';
import { TrainerService } from "src/app/services/trainer/trainer.service";

@Component({
  selector: 'app-trainer',
  templateUrl: './trainer.component.html',
  styleUrls: ['./trainer.component.css']
})
export class TrainerComponent implements OnInit {

  trainer: Trainer | undefined;

  constructor(private trainerService : TrainerService) { }

  ngOnInit(): void {
    this.getTrainerByName('test');
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
        console.log('Trainer saved');
      })
  }
}
