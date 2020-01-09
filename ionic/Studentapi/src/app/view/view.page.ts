import { Component, OnInit } from '@angular/core';
import { ApiService } from '../service/api.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Iresponse } from '../interface/Iresponse';
import { Router, ActivatedRoute } from '@angular/router';
import { Istudent } from '../interface/Istudent';

@Component({
  selector: 'app-view',
  templateUrl: './view.page.html',
  styleUrls: ['./view.page.scss'],
})
export class ViewPage implements OnInit {

  private student: Istudent;
  constructor(private _router: Router, private _activeroute: ActivatedRoute, private _ser: ApiService) {
    this.getStudentData();
  }

  ngOnInit() {
  }


  private getStudentData() {
    let id: string = this._activeroute.snapshot.paramMap.get('id').toString();
    this._ser.getById(id).subscribe(data => {
      this.student = data.resp;
    }, (err) => {
      alert("Data not Found");
      this.redirectToHome()
    })
  }

  private redirectToHome() {
    this._router.navigate(['/home']);
  }
  genderSet(value: boolean): string {
    console.log(this.student);
    console.log(typeof value, value);
    if (value) {
      return 'Male';
    }
    return 'Female';
  }

  private redirectToEdit() {
    this._router.navigate([`edit/${this.student.id}`]);
  }

  delete() {
    if (confirm('Are you sure want to delete ?')) {
      this._ser.delete(this.student.id).subscribe(data => {
        alert('Deleted');
        this.redirectToHome();
      }, (err) => {
        alert(JSON.stringify(err));
        this.redirectToHome();
      });
    }
  }
}
