import { Component, OnInit, Input } from '@angular/core';

@Component({
    selector: 'app-child',
    templateUrl: './child.component.html'
})

export class ChildComponent implements OnInit {

    @Input() onState: string;
    @Input() offState: string;

    public btnStatus: number;
    public btnStyle: string;
    constructor() {
        this.offState = 'red';
        this.onState = 'green';
    }

    ngOnInit() {
        this.btnStatus = 1;
        this.btnStyle = this.onState;
    }

    onBtnToggle() {
        if (this.btnStatus == 1) {
            this.btnStatus = 0;
            this.btnStyle = this.offState;
            return;
        }
        this.btnStatus = 1;
        this.btnStyle = this.onState;
    }
}