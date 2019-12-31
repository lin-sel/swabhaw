import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { StudentServiceService } from '../student-service.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  private addForm: FormGroup;

  constructor(private _ser: StudentServiceService, private _router: Router) {
    this.initializeForm();
  }

  ngOnInit() {
  }

  initializeForm() {
    this.addForm = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.email),
      rollNo: new FormControl(''),
      age: new FormControl(''),
      date: new FormControl('')
    });
  }

  onSubmit() {
    this.storeData();
  }

  private storeData() {
    this._ser.addStudent(this.addForm.value).subscribe((data) => {
      alert(`Data Added Successfully ${data}`);
      this.redirect();
    }, error => {
      console.log(`Failed`);
    });
  }

  redirect() {
    this._router.navigate(['home']);
  }
}
