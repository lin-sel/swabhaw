import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
    selector: 'app-child',
    templateUrl: './child.component.html'
})

export class ChildComponent implements OnInit {

    @Input() onState: string;
    @Input() offState: string;
    @Output() btnState = new EventEmitter<string>();

    public btnStatus: number;
    public btnStyle: string;
    constructor() {
        this.offState = 'red';
        this.onState = 'green';
    }

    ngOnInit() {
        this.btnStatus = 0;
        this.btnStyle = this.offState;
    }

    onBtnToggle() {
        if (this.btnStatus == 1) {
            this.btnStatus = 0;
            this.btnStyle = this.offState;
            this.btnState.emit(`Button status ${this.btnStatus == 1 ? 'on' : 'off'}`);
            return;
        }
        this.btnStatus = 1;
        this.btnStyle = this.onState;
        this.btnState.emit(`Button status ${this.btnStatus == 1 ? 'on' : 'off'}`);
    }
}