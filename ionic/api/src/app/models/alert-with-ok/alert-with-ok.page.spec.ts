import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { AlertWithOkPage } from './alert-with-ok.page';

describe('AlertWithOkPage', () => {
  let component: AlertWithOkPage;
  let fixture: ComponentFixture<AlertWithOkPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlertWithOkPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(AlertWithOkPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
