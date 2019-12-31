import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { StudentServiceService } from '../student-service.service';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { IStudent } from '../interface/Istudent';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  private updateForm: FormGroup;
  private studentData: IStudent;
  constructor(private _ser: StudentServiceService, private _router: Router, private _activeRoute: ActivatedRoute) {
    this.initializeForm();
  }

  ngOnInit() {
    this._activeRoute.paramMap.subscribe((param: ParamMap) => {
      console.log(param.get('studentid'));
      this.getStudentData(param.get('studentid'));
    });
  }

  initializeForm() {
    this.updateForm = new FormGroup({
      name: new FormControl('', Validators.required),
      email: new FormControl('', Validators.email),
      rollNo: new FormControl(''),
      age: new FormControl(''),
      date: new FormControl('')
    });
  }

  updateValue() {
    this.updateForm.patchValue({
      name: this.studentData.name,
      age: this.studentData.age,
      date: this.studentData.date,
      rollNo: this.studentData.rollNo,
      email: this.studentData.email,
    });
  }

  getStudentData(id: string) {
    this._ser.getStudent(id).subscribe(data => {
      this.studentData = data[0];
      this.updateValue();
    }, error => {
      console.log(error);
    })
  }

  onSubmit() {
    this._ser.putStudentDetail(this.updateForm.value, this.studentData.id).subscribe(resp => {
      alert("Detail Update Successfully");
      this._router.navigate(['home']);
    }, err => {
      console.log(err);
    });
  }

  redirect() {
    this._router.navigate(['home']);
  }

}
