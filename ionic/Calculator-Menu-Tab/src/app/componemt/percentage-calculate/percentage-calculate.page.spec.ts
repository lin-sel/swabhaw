import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PercentageCalculatePage } from './percentage-calculate.page';

describe('PercentageCalculatePage', () => {
  let component: PercentageCalculatePage;
  let fixture: ComponentFixture<PercentageCalculatePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PercentageCalculatePage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PercentageCalculatePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
