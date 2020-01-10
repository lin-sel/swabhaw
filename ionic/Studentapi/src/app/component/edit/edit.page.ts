import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../service/apiservice/api.service';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Iresponse } from '../../interface/Iresponse';
import { Router, ActivatedRoute } from '@angular/router';
import { Istudent } from '../../interface/Istudent';
import { LoadingService } from 'src/app/service/loaderservice/loading.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.page.html',
  styleUrls: ['./edit.page.scss'],
})
export class EditPage implements OnInit {

  private editStudent: any;
  private gender: string;
  private submitted: boolean;
  constructor(private _ser: ApiService, private _router: Router, private _activeroute: ActivatedRoute, private _formBuilder: FormBuilder, private _loading: LoadingService) {
    this.initForm();
    this.getStudentData();
    this.submitted = false;
    this._loading.presentLoadingWithOptions();
  }

  ngOnInit() {
  }

  initForm() {
    this.editStudent = this._formBuilder.group({
      id: ['', Validators.required],
      rollNo: ['', Validators.required],
      name: ['', Validators.required],
      age: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      date: ['', Validators.required],
      isMale: ['', Validators.required]
    });
    this.gender = 'false';
  }

  private updateDetail() {
    this.genderClassify();
    this._ser.update(this.editStudent.value).subscribe((data: Iresponse) => {
      this._loading.hideLoading(200);
      alert("Updated");
      this.redirectToHome();
    }, (err) => {
      this._loading.hideLoading(200);
      if (err.resp.message == undefined) {
        alert('Something wrong.');
        this._router.navigate(['/home']);
        return;
      }
      alert(err.resp.message);
    });
  }

  validateForm() {
    this.submitted = true;
    this._loading.presentLoadingWithOptions();
    console.log(this.editStudent, "in");
    if (this.editStudent.invalid) {
      this._loading.hideLoading(200);
      console.log("invalid");
      return;
    }
    if (!this.editStudent.dirty) {
      this.redirectToHome();
      alert('Nothing updated');
      this._loading.hideLoading(300);
      return;
    }
    this.updateDetail();
  }

  private updateFormData(student: Istudent) {
    this.editStudent = this._formBuilder.group({
      id: [student.id, Validators.required],
      rollNo: student.rollNo,
      name: student.name,
      age: student.age,
      email: [student.email, [Validators.required, Validators.email]],
      date: student.date,
      isMale: student.isMale
    });
    this.setGender();
  }

  private getStudentData() {
    let id: string = this._activeroute.snapshot.paramMap.get('id').toString();
    this._ser.getById(id).subscribe(data => {
      this.updateFormData(data.resp);
      this._loading.hideLoading(300);
    }, (err) => {
      this._loading.hideLoading(300);
      alert("Data not Found");
      this.redirectToHome()
    })
  }

  private redirectToHome() {
    this._router.navigate(['/home']);
  }

  get f() {
    return this.editStudent.controls;
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
}
