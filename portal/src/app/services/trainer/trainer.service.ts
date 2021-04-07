import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Trainer } from 'src/app/models/trainer/trainer';
import { catchError, tap } from 'rxjs/operators';
import { ErrorHandler } from "src/app/utils/error-handler.utils";

@Injectable({
  providedIn: 'root'
})
export class TrainerService extends ErrorHandler {
    private virtualTrainerApi = "http://localhost:8080/virtual-trainer";

    httpOptions = {
      headers: new HttpHeaders({'Content-Type:': 'application/json'})
    };
  
    constructor(private http: HttpClient) { 
      super(); 
    }
  
    getTrainerByName(name: string): Observable<any> {
        const url = `${this.virtualTrainerApi}/trainer/${name}`;
        return this.http.get(url);
    }
    
    saveTrainer(trainer: Trainer): Observable<Trainer> {
        return this.http
            .post<Trainer>(`${this.virtualTrainerApi}/trainer`, trainer, this.httpOptions)
            .pipe(
                tap(_ => {
                  alert('Personal Trainer saved!');
                }),
                catchError(this.handleError)
            );
    }
}
