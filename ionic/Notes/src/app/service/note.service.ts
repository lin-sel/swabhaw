import { Injectable } from '@angular/core';
import { INote, IResponse } from '../interface/Interface';
import { DBService } from './db.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  private url: string = './assets/resource/note.json';
  private notes: INote[];
  constructor(private _dbser: DBService) {
    this.notes = [];
  }


  get(id: string) {
    console.log(this.notes);
    for (let i = 0; i < this.notes.length; i++) {
      console.log(id, this.notes[i]);
      if (id == this.notes[i].id) {
        return { status: true, data: this.notes[i] };
      }
    }
    return { status: false, data: "Not Found" };
  }


  getAll(): Observable<IResponse> {
    return new Observable((observe) => {
      this._dbser.getData().then((data) => {
        if (data == null) {
          data = [];
        }
        this.notes = data;
        console.log(this.notes);
        observe.next({ status: true, data: this.notes });
        return;
      }, (err) => {
        observe.error({ status: false, data: err });
      });
    });
  }

  add(note: INote): Observable<IResponse> {
    return new Observable((observer) => {
      this.notes.push(note);
      this.updateAll(this.notes).subscribe((data) => {
        observer.next({ status: data.status, data: "Added SUccessfully" })
      }, (err) => {
        observer.error({ status: false, data: err });
      })
    });
  }

  private mutateNotes(note: INote) {
    for (let i = 0; i < this.notes.length; i++) {
      if (note.id == this.notes[i].id) {
        this.notes[i] = note;
        return true;
      }
    }
    return false;
  }

  update(note: INote): Observable<IResponse> {
    this.mutateNotes(note);
    return new Observable((observe) => {
      this.updateAll(this.notes).subscribe((data) => {
        observe.next({ status: true, data: "Update Successfully" });
        return;
      }, (err) => {
        observe.error({ status: false, data: err });
      });
    })
  }

  updateAll(note: INote[]): Observable<IResponse> {
    return new Observable((observe) => {
      this._dbser.addData(note).then((data) => {
        observe.next({ status: true, data: "Update Successfully" });
        return;
      }, (err) => {
        observe.error({ status: false, data: err });
      });
    })
  }

  delete(id: string): Observable<IResponse> {
    return new Observable((observe) => {
      let stats = this.spliceNote(id);
      if (stats.status) {
        this.updateAll(this.notes).subscribe((data) => {
          observe.next({ status: data.status, data: data.data });
        }, (err) => {
          observe.error({ status: false, data: "Not Deleted" });
        });
        return;
      }
      observe.error({ status: false, data: "Data Not Found" });
    });
  }

  private spliceNote(id: string) {
    for (let i = 0; i < this.notes.length; i++) {
      if (id == this.notes[i].id) {
        this.notes.splice(i, 1);
        return { status: true, data: "Deleted SuccessFully" };
      }
    }
    return { status: false, data: "Data Not Found" };
  }
}
