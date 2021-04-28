import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerSearchComponent } from './trainer-search.component';

describe('TrainerSearchComponent', () => {
  let component: TrainerSearchComponent;
  let fixture: ComponentFixture<TrainerSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainerSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
