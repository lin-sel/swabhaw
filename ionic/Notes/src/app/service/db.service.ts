import { Injectable } from '@angular/core';
import { Storage } from '@ionic/storage';
import { INote } from '../interface/Interface';

@Injectable({
  providedIn: 'root'
})
export class DBService {

  constructor(private _storage: Storage) {

  }

  getData() {
    return this._storage.get('note');
  }

  addData(data) {
    console.log(typeof (data));
    return this._storage.set('note', data);
  }
}
