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
  studentData: IStudent[] = Array();
  private index: number;
  constructor(private _ser: StudentServiceService, private _router: Router) {
  }

  ngOnInit() {
    this.getData();
  }

  getData() {
    this._ser.getStudentList().subscribe((data) => {
      this.studentData = data;
    });
  }

  deleteStudent(id) {
    this._ser.deleteStudent(id).subscribe(() => {
      alert("Deleted SuccessFully");
      this.getData();
    }, error => {
      console.log(error);
    });
  }

  getStudData(ind: number) {
    this.index = ind;
  }
}
