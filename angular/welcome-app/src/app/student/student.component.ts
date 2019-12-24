import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  student: IStudent[];
  manyStudent: IStudent[];
  imgmaxWidth: number = 50;
  imgmaxHeight: number = 50
  constructor() {
    console.log('Inside Constructor');
  }

  ngOnInit() {
    console.log("Inside ngOnInit");
    this.student = [{
      id: 201,
      name: "Nilesh",
      cgpa: 2.6,
      profile: "assets/img/img.png"
    }, {
      id: 301,
      name: "ABC",
      cgpa: 7.1,
      profile: "assets/img/img.png"
    }, {
      id: 401,
      name: "XYZ",
      cgpa: 6.1,
      profile: "assets/img/img.png"
    }, {
      id: 311,
      name: "PQR",
      cgpa: 9.1,
      profile: "assets/img/img.png"
    }, {
      id: 381,
      name: "QRT",
      cgpa: 5.1,
      profile: "assets/img/img.png"
    }];

    this.change();
  }

  change() {
    setTimeout(() => {
      this.student[0].cgpa = 8.2
    }, 2000);
  }

  loadData() {
    console.log('Event Fire');
    this.manyStudent = this.student;
  }

  changeColor(cgpa) {
    if (cgpa <= 5.1) {
      return 'red';
    }
    else if (cgpa > 5.1 && cgpa < 8.1) {
      return 'yellow';
    }
    return 'green';
  }

}

interface IStudent {
  id: number,
  name: string,
  cgpa: number,
  profile: string
}
