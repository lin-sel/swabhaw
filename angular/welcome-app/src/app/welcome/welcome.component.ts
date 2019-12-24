import { Component } from '@angular/core';

@Component({
    selector: 'sw-student',
    templateUrl: './welcome.component.html'
})
export class WelcomeComponent {
    message = "Welcome App";
    num = 22 / 7;
    dateval = new Date();

    get Message() {
        return this.message;
    }

    greetMe() {
        let time = this.dateval.getHours();
        if (time >= 5 && time < 12) {
            return 'Good Morning';
        }
        else if (time > 12 && time < 18) {
            return "Good Afternoon";
        }
        else {
            return 'Good Evening';
        }
    }
}