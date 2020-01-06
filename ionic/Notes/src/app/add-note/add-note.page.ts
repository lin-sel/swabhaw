import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NoteService } from '../service/note.service';


@Component({
  selector: 'app-add-note',
  templateUrl: './add-note.page.html',
  styleUrls: ['./add-note.page.scss'],
})
export class AddNotePage implements OnInit {

  private addForm: FormGroup;

  constructor(private _activeRoute: ActivatedRoute, private _router: Router, private _ser: NoteService) {
    this.addForm = new FormGroup({
      id: new FormControl(''),
      title: new FormControl(''),
      message: new FormControl('')
    });
    this.addForm.patchValue({
      id: this.uuid()
    })
  }

  addNote() {
    this._ser.add(this.addForm.value).subscribe((data) => {
      alert(data.data);
    }, (err) => {
      alert(err)
    });
    this._router.navigate(['/home']);
  }

  ngOnInit() {
  }

  uuid() {
    return Math.random().toString(36).substr(2, 4) + Math.random().toString(36).substr(2, 4) + Math.random().toString(36).substr(2, 4) + Math.random().toString(36).substr(2, 4);
  }

}
