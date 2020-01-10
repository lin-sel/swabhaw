import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../service/apiservice/api.service';
// import { FormGroup, FormControl } from '@angular/forms';
// import { Iresponse } from '../interface/Iresponse';
import { Router, ActivatedRoute } from '@angular/router';
import { Istudent } from '../../interface/Istudent';
import { AlertService } from 'src/app/service/alertservice/alert.service';
import { LoadingService } from 'src/app/service/loaderservice/loading.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.page.html',
  styleUrls: ['./view.page.scss'],
})
export class ViewPage implements OnInit {

  private student: Istudent;
  private message: string;
  private header: string;
  constructor(private _router: Router, private _activeroute: ActivatedRoute, private _ser: ApiService, private _alert: AlertService, private _loading: LoadingService) {
    this._loading.presentLoadingWithOptions();
    this.getStudentData();
    this.message = 'Are you sure want to delete ?';
    this.header = "Confirmation";
  }

  ngOnInit() {
  }


  private getStudentData() {
    let id: string = this._activeroute.snapshot.paramMap.get('id').toString();
    this._ser.getById(id).subscribe(data => {
      this.student = data.resp;
      this._loading.hideLoading(200);
    }, (err) => {
      this._loading.hideLoading(300);
      alert("Data not Found");
      this.redirectToHome()
    });
  }

  private redirectToHome() {
    this._router.navigate(['/home']);
  }
  genderSet(value: boolean): string {
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
      this._loading.presentLoadingWithOptions();
      this._ser.delete(this.student.id).subscribe(data => {
        this._loading.hideLoading(100);
        alert('Deleted');
        this.redirectToHome();
      }, (err) => {
        this._loading.hideLoading(100);
        alert(err.resp.message);
        this.redirectToHome();
      });
    }
  }
}
