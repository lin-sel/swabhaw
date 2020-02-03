import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { PercentageOfPage } from './percentage-of.page';

describe('PercentageOfPage', () => {
  let component: PercentageOfPage;
  let fixture: ComponentFixture<PercentageOfPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PercentageOfPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(PercentageOfPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
