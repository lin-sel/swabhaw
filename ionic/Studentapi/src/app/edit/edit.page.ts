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
  }

  private updateDetail() {
    console.log(this.editStudent);
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

}
