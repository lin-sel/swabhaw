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
      private male: boolean;
      private female: boolean;
      private loader: string;
      private mainDiv: string;
      constructor(private _ser: StudentServiceService, private _router: Router) {
            this.initializeForm();
            this.male = true;
            this.female = false;
            this.loader = 'show';
            this.mainDiv = 'hide';
      }

      ngOnInit() {
            this.loaderSetting();
      }

      initializeForm() {
            this.addForm = new FormGroup({
                  name: new FormControl('', Validators.required),
                  email: new FormControl('', Validators.email),
                  rollNo: new FormControl(''),
                  age: new FormControl(''),
                  date: new FormControl(''),
                  isMale: new FormControl('')
            });
      }

      onSubmit() {
            this.loaderSetting();
            this.storeData();
      }

      private storeData() {
            this.addForm.controls['isMale'].setValue(this.getBool(this.addForm.controls['isMale'].value))
            console.log(this.addForm.value);
            this._ser.addStudent(this.addForm.value).subscribe((data) => {
                  alert(`Data Added Successfully ${data}`);
                  this.redirect();
            }, error => {
                  alert('Data Not Added, Something wrong with server');
                  this._router.navigate(['home']);
            });
      }

      getBool(s: string): boolean {
            return s == "true"
      }

      redirect() {
            this._router.navigate(['home']);
      }

      loaderSetting() {
            if (this.loader == 'show') {
                  this.loader = 'hide';
                  this.mainDiv = 'container';
                  return;
            }
            this.loader = 'show';
            this.mainDiv = 'hide';
      }
}
