import { Component, OnInit, ViewChild, AfterViewInit, ViewChildren } from '@angular/core';
import { QBankServiceService } from '../service/qbank-service.service'
import { IQuestion } from '../interface/IQuestion';
import { Iresponse } from '../interface/returnStatus';

@Component({
  selector: 'app-question-bank',
  templateUrl: './question-bank.component.html',
  styleUrls: ['./question-bank.component.css']
})
export class QuestionBankComponent implements OnInit, AfterViewInit {
  @ViewChildren('radioInput') radioinput;
  private question: IQuestion[];
  private currentQuestion: IQuestion;
  private questionIndex = 0;
  private selectedAnswer: number[] = Array();
  private checkboxname: string;
  private result: number;
  private defaultClass: string;
  private hideClass: string;

  constructor(private _qService: QBankServiceService) {
    this.checkboxname = "checkbox";
    this.defaultClass = "show";
    this.hideClass = "hide"
  }

  ngOnInit() {
    this.getQuestionList();
  }

  ngAfterViewInit() {

  }
  getQuestionList() {
    if (this.question == undefined) {
      this._qService.getQuestion().subscribe((data) => {
        this.question = data;
        this.getCurrentQues(this.questionIndex);
      }, (error) => {
        console.log(error);
      });
    }
  }

  getHeading(): string {
    return (this.questionIndex + 1) + "/" + this.question.length;
  }

  private getCurrentQues(index: number) {
    if (index <= -1 || index >= this.question.length) {
      this.currentQuestion = { id: 0, question: "Question Not Found", option: [null], ans: 0 };
      return;
    }
    this.currentQuestion = this.question[index];
  }

  private getQuestionAns(index: number): any {
    if (index <= -1 || index >= this.question.length) {
      return { status: false, data: "Question not Found" };
    }
    return { status: true, data: this.question[index].option[this.question[index].ans].option };
  }

  private loadNextQues() {
    if (this.questionIndex >= this.question.length) {
      console.log("Can not Go Next");
      return;
    }
    this.questionIndex += 1;
    this.getCurrentQues(this.questionIndex);
    return;
  }

  private storeSelectedAnswer(element) {
    console.log(element.value);
    if (this.selectedAnswer[this.questionIndex] == undefined) {
      this.selectedAnswer.push(element.value);
      return;
    }
    this.selectedAnswer[this.questionIndex] = element.value;
  }

  // debugger
  // appendSelectedAnswer() {
  //   this.radioinput._results[this.selectedAnswer[this.questionIndex]].nativeElement.checked = true;
  // }

  private isAnswerSelected(): Iresponse {
    for (let index = 0; index < this.radioinput._results.length; index++) {
      if (this.radioinput._results[index].nativeElement.name == this.checkboxname &&
        this.radioinput._results[index].nativeElement.type == 'radio' &&
        this.radioinput._results[index].nativeElement.checked) {
        return { status: true, data: this.radioinput._results[index].nativeElement };
      }
    }
    return { status: false, data: "Not checked" };
  }

  private calculateResult() {
    let currectans = 0;
    for (let index = 0; index < this.selectedAnswer.length; index += 1) {
      if (this.question[index].ans == this.selectedAnswer[index]) {
        currectans++;
      }
    }
    this.result = this.getPercentage(currectans, this.question.length);
  }

  private getPercentage(currectans, totalQuestion): number {
    let sp = (currectans / totalQuestion) * 100;
    console.log(sp, currectans, totalQuestion);
    return (currectans / totalQuestion) * 100;
  }

  // Event Listner for Button.

  onPrevClick() {
    if (this.questionIndex == 0) {
      console.log("Can not Go Back");
      return;
    }
    this.questionIndex -= 1;
    this.getCurrentQues(this.questionIndex);
    // this.appendSelectedAnswer();
  }

  onNextClick() {
    let response: Iresponse = this.isAnswerSelected();
    if (response.status) {
      this.storeSelectedAnswer(response.data);
      this.loadNextQues();
      return;
    }
    alert("Please Select Option First");
  }

  onFinishClick() {
    let response: Iresponse = this.isAnswerSelected();
    if (response.status) {
      this.storeSelectedAnswer(response.data);
      console.log(this.selectedAnswer);
      this.calculateResult();
      this.changeStyleClass();
      return;
    }
    alert("Please Select Option First");
  }

  changeStyleClass() {
    this.defaultClass = this.hideClass;
    this.hideClass = 'show';
  }
}
