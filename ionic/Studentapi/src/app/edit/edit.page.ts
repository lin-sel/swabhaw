import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Iresponse } from '../interface/Iresponse';
import { Router, ActivatedRoute } from '@angular/router';
import { Istudent } from '../interface/Istudent';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.page.html',
  styleUrls: ['./edit.page.scss'],
})
export class EditPage implements OnInit {

  private editStudent: FormGroup;
  private gender: string;
  constructor(private _ser: ApiService, private _router: Router, private _activeroute: ActivatedRoute) {
    this.initForm();
    this.getStudentData();
  }

  ngOnInit() {
  }

  initForm() {
    this.editStudent = new FormGroup({
      id: new FormControl(''),
      rollNo: new FormControl(''),
      name: new FormControl(''),
      age: new FormControl(''),
      email: new FormControl(''),
      date: new FormControl(''),
      isMale: new FormControl('')
    });
    this.gender = 'false';
  }

  private updateDetail() {
    this.genderClassify();
    this._ser.update(this.editStudent.value).subscribe((data: Iresponse) => {
      alert("Updated");
      this.redirectToHome();
    }, (err) => {
      alert(err.message);
      this.redirectToHome();
    });
  }

  validateForm() {
    if (!this.editStudent.dirty) {
      this.redirectToHome();
      alert('Nothing updated');
      return;
    }
    if (this.editStudent.controls['name'].invalid) {
      alert('Please enter Name');
      return;
    }
    if (this.editStudent.controls['rollNo'].invalid) {
      alert('Please enter Roll Number');
      return;
    }
    if (this.editStudent.controls['id'].invalid) {
      alert('Please enter id');
      return;
    }
    if (this.editStudent.controls['age'].invalid) {
      alert('Please enter Age');
      return;
    }
    if (this.editStudent.controls['email'].invalid) {
      alert('Please enter valid Email');
      return;
    }
    if (this.editStudent.controls['date'].invalid) {
      alert('Please enter date');
      return;
    }
    this.updateDetail();
  }

  private updateFormData(student: Istudent) {
    this.editStudent.patchValue({
      id: student.id,
      rollNo: student.rollNo,
      name: student.name,
      age: student.age,
      email: student.email,
      date: student.date,
      isMale: student.isMale
    });
    this.setGender();
  }

  private getStudentData() {
    let id: string = this._activeroute.snapshot.paramMap.get('id').toString();
    this._ser.getById(id).subscribe(data => {
      this.updateFormData(data.resp);
    }, (err) => {
      alert("Data not Found");
      this.redirectToHome()
    })
  }

  private redirectToHome() {
    this._router.navigate(['/home']);
  }

  genderClassify() {
    if (this.editStudent.controls['isMale'].value == "true") {
      this.editStudent.controls['isMale'].setValue(true);
      return;
    }
    this.editStudent.controls['isMale'].setValue(false);
  }

  setGender() {
    if (this.editStudent.controls['isMale'].value) {
      this.gender = "true";
      return;
    }
    this.gender = "false";
  }
  emailValidate(email): boolean {
    return this.editStudent.contains['email'].value.test(/[a-zA-Z0-9]+@+[a-zA-Z0-9]+.+[a-zA-Z]/);
  }

}
