import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PercentageDifferencePage } from './percentage-difference.page';

describe('PercentageDifferencePage', () => {
  let component: PercentageDifferencePage;
  let fixture: ComponentFixture<PercentageDifferencePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PercentageDifferencePage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PercentageDifferencePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
