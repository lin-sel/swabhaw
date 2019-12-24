import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-blueball',
  templateUrl: './blueball.component.html',
  styleUrls: ['./blueball.component.css']
})
export class BlueballComponent implements OnInit {

  balls: IBall[]
  numberOfBall = 50;
  DEFAULT_COLOR = 'gray';
  buttonWidth = 50;
  buttonHeight = 50;
  subDiv = 'subDiv'
  blueball: number;
  LOW_NUMBER_COLOR = 'green';
  HIGH_NUMBER_COLOR = 'red';
  BLUE_BALL_COLOR = 'blue';
  TOTAL_TURN = 5;
  mainDiv = 'hideDiv'
  rulesDiv = 'rulesDiv';

  constructor() {

  }

  ngOnInit() {
    this.generateBalls();
    this.blueball = getBlueBall(this.numberOfBall);
  }

  generateBalls() {
    this.balls = Array();
    for (let i = 0; i < this.numberOfBall; i++) {
      this.balls.push({ id: i + 1, color: this.DEFAULT_COLOR, width: this.buttonWidth, height: this.buttonHeight });
    }
  }

  updatePage() {
    this.mainDiv = 'mainDiv';
    this.rulesDiv = 'hideDiv';
  }
  onBallClick(event) {
    console.log(this.blueball);
    this.resultAnalyze(event.target);
    this.checkTurn();
  }

  changeBackgroundColor(element, color) {
    element.style.backgroundColor = color;
  }

  disabledElement(element) {
    element.disabled = 'true';
  }

  resultAnalyze(element) {
    let selectedball = element.id;
    if (selectedball == this.blueball) {
      this.changeBackgroundColor(element, this.BLUE_BALL_COLOR);
      alert("You Win the Game");
      this.reloadPage();
      return;
    }
    else if (selectedball > this.blueball) {
      this.changeBackgroundColor(element, this.HIGH_NUMBER_COLOR);
      this.disabledElement(element);
      return;
    }
    this.changeBackgroundColor(element, this.LOW_NUMBER_COLOR);
    this.disabledElement(element);
  }

  checkTurn() {
    if (this.TOTAL_TURN > 1) {
      this.TOTAL_TURN--;
      return true;
    }
    else {
      this.TOTAL_TURN--;
      alert('You Loose the Game try Next Time');
      this.reloadPage();
    }
  }

  reloadPage() {
    setTimeout(() => {
      location.reload();
    }, 2000)
  }
}

interface IBall {
  id: number
  color: string
  width: number
  height: number
}

function getBlueBall(totalball) {
  return Math.round(Math.random() * 100) % totalball;
}