import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { DbtestPage } from './dbtest.page';

describe('DbtestPage', () => {
  let component: DbtestPage;
  let fixture: ComponentFixture<DbtestPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DbtestPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(DbtestPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
