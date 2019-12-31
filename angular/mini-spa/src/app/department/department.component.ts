import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {
  private id: number;
  constructor(private _route: ActivatedRoute, private _router: Router) { }

  ngOnInit() {
    this._route.paramMap.subscribe((param: ParamMap) => {
      this.verifyPara(param.get('id'));
    });
  }
  verifyPara(id) {
    if (isNaN(parseInt(id))) {
      this._router.navigate(['NotFound']);
      console.log(this.id);
      return;
    }
    this.id = parseInt(id);

  }

}
