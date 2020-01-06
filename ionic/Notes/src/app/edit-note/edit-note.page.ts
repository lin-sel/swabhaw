import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NoteService } from '../service/note.service';


@Component({
  selector: 'app-edit-note',
  templateUrl: './edit-note.page.html',
  styleUrls: ['./edit-note.page.scss'],
})
export class EditNotePage implements OnInit {

  private editForm: FormGroup;

  constructor(private _activeRoute: ActivatedRoute, private _router: Router, private _ser: NoteService) {
    this.editForm = new FormGroup({
      id: new FormControl(''),
      title: new FormControl(''),
      message: new FormControl('')
    });
    this.getEditableNote()
  }

  ngOnInit() {
  }

  getEditableNote() {
    let note = this._ser.get(this._activeRoute.snapshot.paramMap.get('id').toString());
    if (note.status) {
      this.patchValues(note.data);
      return;
    }
    alert(note.data);
    this._router.navigate(['/home']);
  }

  patchValues(note) {
    this.editForm.patchValue({
      id: note.id,
      title: note.title,
      message: note.message
    });
  }

  updateNote() {
    this._ser.update(this.editForm.value).subscribe((data) => {
      alert(data.data);
    }, (err) => {
      alert(err)
    });
    this._router.navigate(['/home']);
  }
}
