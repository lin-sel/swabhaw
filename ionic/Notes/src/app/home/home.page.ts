import { Component, ViewChild, OnInit } from '@angular/core';
import { IonReorderGroup } from '@ionic/angular';
import { NoteService } from '../service/note.service';
import { INote } from '../interface/Interface';
import { Router } from '@angular/router';
import { DBService } from '../service/db.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
  private suffle: boolean;
  private notes: INote[] = Array();
  @ViewChild(IonReorderGroup, null) reordergroup: IonReorderGroup;
  constructor(private _ser: NoteService, private _router: Router, private sqlite: DBService) {
    this.notes = [];
    this.suffle = true;
    this.getNotes();
  }

  ngOnInit() {
    this.getNotes();
  }

  suffleEnable() {
    if (this.suffle) {
      this.suffle = false;
      return;
    }
    this.suffle = true;
  }

  reOrder(event) {
    this.notes = event.detail.complete(this.notes);
    this._ser.updateAll(this.notes).subscribe((data) => {
      alert(data.data);
    });
  }

  getNotes() {
    this._ser.getAll().subscribe((data) => {
      if (!data.data) {
        this.notes = [];
        return;
      }
      this.notes = data.data;
    }, (err) => {
      alert("err" + err);
    });

  }

  redirectTo(id: string) {
    this._router.navigate(['/edit-note/' + id]);
  }

  redirectAdd() {
    this._router.navigate(['/add-note/']);
  }

  delete(evt) {
    this._ser.delete(evt).subscribe((data) => {
      alert("Deleted Successfully");
      this._router.navigate(['/home']);
    }, (err) => {
      alert(err);
      this._router.navigate(['/home']);
    });
  }

}
