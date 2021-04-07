import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student/student';
import { StudentService } from 'src/app/services/student/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  student: Student | undefined;

  constructor(private studentService : StudentService) { }

  ngOnInit(): void {
    this.getStudentByName('test');
  }

  getStudentByName(name: string) {
    this.studentService
      .getStudentByName(name)
      .subscribe(_ => this.student = _);
  }

  saveStudent(student: Student) {
    this.studentService
      .saveStudent(student)
      .subscribe(_ => {
        console.log('Student saved');
      })
  }
}