import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { IQuestion } from '../interface/IQuestion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class QBankServiceService {
  private url: string = '/assets/resource/QuestionList.json';

  constructor(private _http: HttpClient) {
    this.getQuestion();
  }

  getQuestion(): Observable<IQuestion[]> {
    return this._http.get<IQuestion[]>(this.url, { responseType: 'json' });
  }

}
