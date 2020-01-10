import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { ApiService } from '../../service/apiservice/api.service';
import { Router } from '@angular/router';
import { Iresponse } from '../../interface/Iresponse';
import { LoadingService } from 'src/app/service/loaderservice/loading.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.page.html',
  styleUrls: ['./add.page.scss'],
})
export class AddPage implements OnInit {

  private addStudent: any;
  private submitted: boolean;
  constructor(private _ser: ApiService, private _router: Router, private formBuilder: FormBuilder, private _loading: LoadingService) {
    this.initForm();
    this.submitted = false;
  }

  ngOnInit() {
  }

  initForm() {
    this.addStudent = this.formBuilder.group({
      rollNo: ['', Validators.required],
      name: ['', Validators.required],
      age: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      date: ['', Validators.required],
      isMale: ['', Validators.required]
    });
  }

  private updateDetail() {
    this._ser.add(this.addStudent.value).subscribe((data: Iresponse) => {
      this._loading.hideLoading(200);
      alert("Detail Added");
      this.redirectToHome();
    }, (err) => {
      alert("Adding Request Failed");
      this._loading.hideLoading(200);
      this.redirectToHome();
    });
  }

  validateForm() {
    this.submitted = true;
    this._loading.presentLoadingWithOptions();
    if (this.addStudent.invalid) {
      this._loading.hideLoading(200);
      return;
    }
    this.updateDetail();
  }

  private redirectToHome() {
    this._router.navigate(['/home']);
  }

  get f() {
    return this.addStudent.controls;
  }

}
