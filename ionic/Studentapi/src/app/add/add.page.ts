import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ApiService } from '../service/api.service';
import { Router } from '@angular/router';
import { Iresponse } from '../interface/Iresponse';

@Component({
  selector: 'app-add',
  templateUrl: './add.page.html',
  styleUrls: ['./add.page.scss'],
})
export class AddPage implements OnInit {

  private addStudent: FormGroup;
  constructor(private _ser: ApiService, private _router: Router) {
    this.initForm();
  }

  ngOnInit() {
  }
  initForm() {
    this.addStudent = new FormGroup({
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
    console.log(this.addStudent);
    this._ser.add(this.addStudent.value).subscribe((data: Iresponse) => {
      alert("Detail Added");
      this.redirectToHome();
    }, (err) => {
      alert(err);
      this.redirectToHome();
    });
  }

  validateForm() {
    if (this.addStudent.invalid) {
      alert('Please all Fill Data');
      return;
    }
    this.updateDetail();
  }

  private redirectToHome() {
    this._router.navigate(['/home']);
  }

}
