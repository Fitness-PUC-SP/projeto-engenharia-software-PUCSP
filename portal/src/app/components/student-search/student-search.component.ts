import { StudentService } from './../../services/student/student.service';
import { Student } from './../../models/student/student';
import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-student-search',
  templateUrl: './student-search.component.html',
  styleUrls: ['./student-search.component.scss']
})
export class StudentSearchComponent implements OnInit {

  students$: Observable<Student[]>;

  // A Subject is both a source of observable values and an Observable itself. You can subscribe to a Subject as you would any Observable.
  // You can also push values into that Observable by calling its next(value) method as the search() method does.
  private searchTerms = new Subject<string>();

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    // this.students$ = this.searchTerms
    //   .pipe(
    //     debounceTime(300),  // wait 300ms after each keystroke before considering the term
    //     distinctUntilChanged(), // ignore new term if same as previous term
    //     switchMap((term: string) => this.studentService.searchStudent(term))  // switch to new search observable each time the term changes
    //   );
  }

  search(term: string): void {
    this.searchTerms.next(term); // push term to the "searchTerms" observable stream
  }
}
