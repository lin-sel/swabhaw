import { Component, OnInit } from '@angular/core';
import { StudentServiceService } from '../student-service.service';
import { IStudent } from '../interface/Istudent';
import { Router } from '@angular/router';

@Component({
      selector: 'app-home',
      templateUrl: './home.component.html',
      styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
      editButton: false;
      studentData: IStudent[] = Array();
      index: IStudent;
      loader: string;
      mainDiv: string;
      deleteButton: false;
      constructor(private _ser: StudentServiceService, private _router: Router) {
            this.loader = 'show';
            this.mainDiv = 'hide';
            this.getEmpty();
      }

      ngOnInit() {
            this.getData();
      }

      getEmpty() {
            this.index = {
                  age: 0,
                  date: "",
                  email: "",
                  id: "",
                  name: "",
                  rollNo: 0,
                  isMale: null
            }
      }

      getData() {
            this._ser.getStudentList().subscribe((data) => {
                  this.studentData = data;
                  console.log(this.studentData);
                  this.loaderSetting();
            }, (error) => {
                  alert("Internal Server Error 500");
                  this.loaderSetting();
            });
      }

      deleteStudent(id) {
            this.loaderSetting();
            this._ser.deleteStudent(id).subscribe(() => {
                  alert("Deleted SuccessFully");
                  this.getData();
            }, error => {
                  alert("Something Went Wrong");
                  this.getData();
            });

      }

      getStudData(student: IStudent) {
            this.index = student;
            console.log(this.index);
      }

      loaderSetting() {
            if (this.loader == 'show') {
                  console.log(this.loader);
                  this.loader = 'hide';
                  this.mainDiv = 'container';
                  return;
            }
            this.loader = 'show';
            this.mainDiv = 'hide';
      }
}
