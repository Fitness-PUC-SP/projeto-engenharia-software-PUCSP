import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Trainer } from 'src/app/models/trainer/trainer';
import { ErrorHandler } from "src/app/utils/error-handler.utils";

@Injectable({
  providedIn: 'root'
})
export class TrainerService extends ErrorHandler {
  private baseApi = "http://localhost:8080/virtual-trainer";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) { 
    super(); 
  }

  getAllTrainers(): Observable<any> {
    const url = `${this.baseApi}/trainer`;
    return this.http.get(url);
  }

  getTrainerByName(name: string): Observable<any> {
    const url = `${this.baseApi}/trainer/${name}`;
    return this.http.get(url);
  }
  
  saveTrainer(trainer: Trainer): Observable<Trainer> {
    return this.http
        .post<Trainer>(`${this.baseApi}/trainer`, trainer, this.httpOptions)
        .pipe(
            tap(_ => {
              // verificar com equipe de back sobre retornos de códigos HTTP
              const test = _;
            }),
            catchError(this.handleError)
        );
  }
}
