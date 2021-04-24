import { TrainerService } from '../../services/trainer/trainer.service';
import { ActivatedRoute } from '@angular/router';
import { Trainer } from '../../models/trainer/trainer';
import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-trainer-search',
  templateUrl: './trainer-search.component.html',
  styleUrls: ['./trainer-search.component.scss']
})
export class TrainerSearchComponent implements OnInit {
  trainer$: Observable<Trainer[]>;

  private searchTerms = new Subject<string>();

  constructor(private trainerService: TrainerService) { }

  ngOnInit(): void {

  }

  search(term: string): void {
    this.searchTerms.next(term); 
  }
}
