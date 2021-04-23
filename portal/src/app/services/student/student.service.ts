import { environment } from './../../../environments/environment';
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

  saveStudent(student: Student): Observable<Student> {
    return this.http
      .post<Student>(`${this.baseApi}/student`, student, this.httpOptions)
      .pipe(
        tap(_ => {
          if (!environment.production) {
            console.log(_);
          }
        }),
        catchError(this.handleError)
      );
  }
  
  updateStudent(student: Student): Observable<Student> {
    return this.http
      .put<Student>(`${this.baseApi}/student`, student, this.httpOptions)
      .pipe(
        tap(_ => {
          if (!environment.production) {
            console.log(_);
          }
        }),
        catchError(this.handleError)
      );
  }

  deleteStudent(id: number): Observable<any> {
    return this.http
      .delete(`${this.baseApi}/student/${id}`, this.httpOptions)
      .pipe(
        tap(_ => {
          if (!environment.production) {
            console.log(_);
          }
        }),
        catchError(this.handleError)
      );
  }

  //#region "Gets for students"
  getStudentByName(name: string): Observable<any> {
    const url = `${this.baseApi}/student/${name}`;
    return this.http.get(url);
  }

  getAllStudents(): Observable<any> {
    const url = `${this.baseApi}/student`;
    return this.http.get(url);
  }

  getStudentById(id: number): Observable<Student> {
    const url = `${this.baseApi}/student/${id}`;
    return this.http.get<Student>(url);
  }
  //#endregion
}
