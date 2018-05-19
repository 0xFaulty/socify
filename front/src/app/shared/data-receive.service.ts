import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import 'rxjs/add/operator/map';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';

@Injectable()
export class DataReceiveService {

  private messageSource = new BehaviorSubject<string>('default message');
  currentMessage = this.messageSource.asObservable();

  constructor(private _http: HttpClient) {
  }

  changeMessage(message: string) {
    this.messageSource.next(message);
  }

  getNewsFeed(query = 'nature') {
    console.log(environment.SOCIFY_API_URL);
    return this._http.get(environment.SOCIFY_API_URL);
  }

}
