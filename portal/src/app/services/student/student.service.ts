import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Student } from 'src/app/models/student/student';
import { ErrorHandler } from "src/app/utils/error-handler.utils";

@Injectable({
  providedIn: 'root'
})
export class StudentService extends ErrorHandler {
  private baseApi = "http://localhost:8080/virtual-trainer";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { 
    super(); 
  }

  getStudentByName(name: string): Observable<any> {
    const url = `${this.baseApi}/student/${name}`;
    return this.http.get(url);
  }

  saveStudent(student: Student): Observable<Student> {
    return this.http
      .post<Student>(`${this.baseApi}/student`, student, this.httpOptions)
      .pipe(
        tap(_ => {
          const test = _;
        }),
        catchError(this.handleError)
      );
  }

  getAllStudents(): Observable<any> {
      const url = `${this.baseApi}/student`;
      return this.http.get(url);
  }
}
