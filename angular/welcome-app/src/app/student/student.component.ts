import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  student: IStudent;
  constructor() {
    console.log('Inside Constructor');
  }

  ngOnInit() {
    console.log("Inside ngOnInit");
    this.student = {
      id: 201,
      name: "Nilesh",
      cgpa: 2.6,
      profile: "assets/img/img.png"
    };

    this.change();
  }

  change() {
    setTimeout(() => {
      this.student.cgpa = 8.2
    }, 2000);
  }


}

interface IStudent {
  id: number,
  name: string,
  cgpa: number,
  profile: string
}
